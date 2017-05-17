package cvm.stars.testng;

import cvm.stars.dao.StarTypeDAO;
import cvm.stars.entities.StarType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by cvm on 18.05.2017.
 */
public class Tester {

    @DataProvider(name = "ValidStarTypeIndices")
    public Object[][] validStarTypeIndices() {
        return new Object[][] {
                {1, "Blue"},
                {2, "White-blue"},
                {3, "White"},
                {4, "Yellow-white"},
                {5, "Yellow"},
                {6, "Orange"},
                {7, "Red"}
        };
    }

    @Test(dataProvider = "ValidStarTypeIndices")
    public void checkStarTypeIndices(final int id, final String expectedResult) {
        StarType starType = new StarTypeDAO().selectById(id);
        Assert.assertEquals(expectedResult, starType.getName());
    }

    @Test()
    public void checkStarTypeRemovables() {
        for (StarType starType : new StarTypeDAO().selectAll()) {
            if (starType.getName().equals("Yellow")) {
                Assert.assertEquals(starType.getRemovable().booleanValue(), false);
            } else {
                Assert.assertEquals(starType.getRemovable().booleanValue(), true);
            }
        }
    }

}
