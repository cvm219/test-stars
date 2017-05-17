package cvm.stars.controllers;

import cvm.stars.dao.DiscovererDAO;
import cvm.stars.dao.StarDAO;
import cvm.stars.dao.StarTypeDAO;
import cvm.stars.entities.Discoverer;
import cvm.stars.entities.Star;
import cvm.stars.forms.StarForm;
import cvm.stars.helpers.SimpleResponse;
import cvm.stars.mybatis.MyBatisConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cvm on 15.05.2017.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "index";
    }

    @RequestMapping(value = "/star-list", method = RequestMethod.GET)
    public String getStarList(Model model) {
        StarDAO starDAO = new StarDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        model.addAttribute("stars", starDAO.selectAll());
        return "fragments/star-list :: starList";
    }

    @RequestMapping(value = "/star-create", method = RequestMethod.GET)
    public String createStarViewLoader(Model model, StarForm starForm) {
        StarTypeDAO starTypeDAO = new StarTypeDAO();
        DiscovererDAO discovererDAO = new DiscovererDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        model.addAttribute("modalTitle", "Add star");
        model.addAttribute("types", starTypeDAO.selectAll());
        model.addAttribute("discoverers", discovererDAO.selectAll());
        model.addAttribute("model", starForm);
        return "fragments/star-form :: modalForm";
    }

    @RequestMapping(value = "/star-edit/{id}", method = RequestMethod.GET)
    public String editStarViewLoader(@PathVariable("id") int id, Model model, StarForm starForm) {
        StarTypeDAO starTypeDAO = new StarTypeDAO();
        StarDAO starDAO = new StarDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        DiscovererDAO discovererDAO = new DiscovererDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        Star star = starDAO.selectById(id);
        if (star == null) {
            return "";
        }
        starForm.setId(star.getId());
        starForm.setName(star.getName());
        starForm.setCoorX(star.getCoorX());
        starForm.setCoorY(star.getCoorY());
        starForm.setType(star.getType().getId());
        starForm.setDiscoverer(star.getDiscoverer().getId());
        model.addAttribute("modalTitle", "Edit star");
        model.addAttribute("types", starTypeDAO.selectAll());
        model.addAttribute("discoverers", discovererDAO.selectAll());
        model.addAttribute("model", starForm);
        return "fragments/star-form :: modalForm";
    }

    @RequestMapping(value = "/star/edit", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public SimpleResponse editStar(StarForm starForm) {
        if (!starForm.validate()) {
            return new SimpleResponse(false, starForm.errorsWithBr());
        }
        StarTypeDAO starTypeDAO = new StarTypeDAO();
        DiscovererDAO discovererDAO = new DiscovererDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        StarDAO starDAO = new StarDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        Star star = null;
        if (starForm.getId() != null) {
            star = starDAO.selectById(starForm.getId());
            if (star == null) {
                starForm.addError("Something goes wrong");
                return new SimpleResponse(false, starForm.errorsWithBr());
            }
        } else {
            star = new Star();
        }
        star.setName(starForm.getName());
        star.setCoorX(starForm.getCoorX());
        star.setCoorY(starForm.getCoorY());
        star.setType(starTypeDAO.selectById(starForm.getType()));
        star.setDiscoverer(discovererDAO.selectById(starForm.getDiscoverer()));
        if (star.getId() == null) {
            starDAO.insert(star);
        } else {
            starDAO.update(star);
        }
        return new SimpleResponse(true, "Done");
    }

    @RequestMapping(value = "/star/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public SimpleResponse deleteStar(@PathVariable("id") int id) {
        StarDAO starDAO = new StarDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        Star star = starDAO.selectById(id);
        if (star != null && !star.getType().getRemovable()) {
            return new SimpleResponse(false, "Star with class \"" + star.getType().getName() + "\" cannot be removed");
        }
        starDAO.delete(id);
        return new SimpleResponse(true, "Star deleted");
    }

    @RequestMapping(value = "/discoverer/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public SimpleResponse addDiscoverer(@RequestParam(value = "discoverer-name", required = true) String discovererName) {
        DiscovererDAO discovererDAO = new DiscovererDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        Discoverer discoverer = discovererDAO.selectByName(discovererName);
        if (discoverer != null) {
            return new SimpleResponse(false, "Discoverer already exists");
        }
        discoverer = new Discoverer();
        discoverer.setName(discovererName);
        discovererDAO.insert(discoverer);
        return new SimpleResponse(true, discoverer.getId().toString());
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid credential provided");
        }
        if (logout != null) {
            model.addAttribute("successMessage", "Logged out successfully");
        }
        return "login";
    }
}
