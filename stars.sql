-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 18 2017 г., 08:45
-- Версия сервера: 10.1.19-MariaDB
-- Версия PHP: 7.0.13

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `stars`
--

-- --------------------------------------------------------

--
-- Структура таблицы `core_discoverers`
--

CREATE TABLE `core_discoverers` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `core_stars`
--

CREATE TABLE `core_stars` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `coor_x` varchar(255) NOT NULL,
  `coor_y` varchar(255) NOT NULL,
  `type_id` int(11) NOT NULL,
  `discoverer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `core_discoverers`
--
ALTER TABLE `core_discoverers`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `core_stars`
--
ALTER TABLE `core_stars`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `core_discoverers`
--
ALTER TABLE `core_discoverers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `core_stars`
--
ALTER TABLE `core_stars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
