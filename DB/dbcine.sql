-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-12-2021 a las 02:35:58
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbcine`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleta`
--

CREATE TABLE `boleta` (
  `idboleta` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(250) NOT NULL,
  `correo` varchar(250) NOT NULL,
  `total` float NOT NULL,
  `idfun` int(11) NOT NULL,
  `qrboleteria` int(11) NOT NULL,
  `qrconfiteria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `boleta`
--

INSERT INTO `boleta` (`idboleta`, `fecha`, `hora`, `correo`, `total`, `idfun`, `qrboleteria`, `qrconfiteria`) VALUES
(1, '2021-11-05', 'asd', '', 14, 3, 0, 0),
(2, '2021-11-09', '15:00', '', 17, 3, 0, 0),
(3, '2021-11-09', '15:00', '', 17, 3, 0, 0),
(4, '2021-11-09', '13:00pm', '', 500, 1, 0, 0),
(5, '2021-11-09', '13:00pm', '', 500, 1, 0, 0),
(6, '2021-11-09', '06:10:10', '', 15, 3, 0, 0),
(7, '2021-11-08', '01:33:03', '', 15, 3, 0, 0),
(8, '2021-11-08', '01:33:30', '', 45, 3, 0, 0),
(9, '2021-11-08', '01:33:54', '', 45, 1, 0, 0),
(10, '2021-11-08', '01:38:27', '', 15, 1, 0, 0),
(11, '2021-11-08', '01:42:35', '', 15, 3, 0, 0),
(12, '2021-11-08', '01:44:12', '', 30, 3, 0, 0),
(13, '2021-11-08', '01:46:20', '', 15, 3, 0, 0),
(14, '2021-11-08', '01:47:36', '', 15, 3, 0, 0),
(15, '2021-11-08', '01:49:50', '', 15, 3, 0, 0),
(16, '2021-11-08', '01:54:01', '', 15, 3, 0, 0),
(17, '2021-11-08', '02:11:41', '', 170.5, 1, 0, 0),
(18, '2021-11-08', '02:12:32', '', 170.5, 1, 0, 0),
(19, '2021-11-08', '02:15:19', '', 58, 2, 0, 0),
(20, '2021-11-08', '02:24:30', '', 157.5, 1, 0, 0),
(21, '2021-11-09', '03:43:00', '', 75, 3, 0, 0),
(22, '2021-11-13', '11:08:16', '', 79.5, 1, 1, 1),
(23, '2021-11-13', '11:10:45', '', 102, 2, 1, 1),
(24, '2021-11-13', '19:11:25', '', 102, 1, 0, 0),
(25, '2021-11-13', '19:39:11', '', 117, 1, 1, 1),
(26, '2021-11-17', '13:53:47', '', 30, 1, 0, 0),
(27, '2021-11-17', '13:54:28', '', 15, 1, 0, 0),
(28, '2021-11-17', '13:54:46', '', 90, 3, 0, 0),
(29, '2021-11-17', '13:56:04', '', 87, 1, 0, 0),
(30, '2021-11-17', '13:56:57', '', 51.5, 1, 0, 0),
(31, '2021-11-17', '14:19:29', '', 123.5, 1, 1, 1),
(32, '2021-11-19', '13:00', 'caballero1@gmail.com', 200, 1, 0, 0),
(33, '2021-11-19', '13:00', 'caballero1@gmail.com', 200, 1, 0, 0),
(34, '2021-11-19', '19:08:04', 'aldaircano325@gmail.com', 87, 1, 0, 0),
(35, '2021-11-19', '19:09:45', 'aldaircano325@gmail.com', 68.5, 2, 0, 0),
(36, '2021-11-19', '19:17:28', 'aldaircano325@gmail.com', 51.5, 3, 0, 0),
(37, '2021-11-19', '19:19:35', 'aldaircano325@gmail.com', 66.5, 2, 0, 0),
(38, '2021-11-19', '19:21:46', 'aldaircano325@gmail.com', 51.5, 1, 0, 0),
(39, '2021-11-19', '19:22:44', 'aldaircano325@gmail.com', 68.5, 2, 0, 0),
(40, '2021-11-19', '19:26:54', 'aldaircano325@gmail.com', 73, 1, 0, 0),
(41, '2021-11-19', '19:30:05', 'aldaircano325@gmail.com', 81.5, 2, 0, 0),
(42, '2021-11-19', '19:33:20', 'chvez4012@gmail.com', 68.5, 1, 0, 0),
(43, '2021-11-19', '19:36:59', 'aldaircano325@gmail.com', 68.5, 2, 0, 0),
(44, '2021-11-19', '19:38:55', 'aldaircano325@gmail.com', 83.5, 2, 0, 0),
(45, '2021-11-19', '19:42:52', 'aldaircano325@gmail.com', 47, 2, 0, 0),
(46, '2021-11-19', '19:53:00', 'aldaircano325@gmail.com', 15, 1, 0, 0),
(47, '2021-11-19', '19:57:38', 'aldaircano325@gmail.com', 87, 1, 1, 1),
(48, '2021-11-19', '20:01:58', 'aldaircano325@gmail.com', 103, 1, 0, 0),
(49, '2021-11-20', '19:01:40', 'aldaircano325@gmail.com', 87, 4, 0, 0),
(50, '2021-11-20', '19:05:06', 'aldaircano325@gmail.com', 72, 1, 1, 1),
(51, '2021-11-20', '19:10:36', 'aldaircano325@gmail.com', 32, 3, 0, 0),
(52, '2021-11-20', '19:25:44', 'aldaircano325@gmail.com', 51.5, 1, 1, 1),
(53, '2021-11-20', '20:13:10', 'aldaircano325@gmail.com', 36.5, 1, 0, 0),
(54, '2021-11-20', '20:31:54', 'aldaircano325@gmail.com', 87, 1, 1, 1),
(55, '2021-11-27', '18:29:13', 'aldaircano325@gmail.com', 73, 3, 0, 1),
(56, '2021-11-27', '20:41:44', 'aldaircano325@gmail.com', 64, 3, 1, 1),
(57, '2021-12-08', '17:22:44', 'aldaircano325@gmail.com', 15, 1, 0, 0),
(58, '2021-12-08', '17:30:46', 'aldaircano325@gmail.com', 87, 1, 1, 1),
(59, '2021-12-27', '23:28:36', 'aldaircano325@gmail.com', 31.5, 2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `idcargo` int(11) NOT NULL,
  `cargo` varchar(250) NOT NULL,
  `sueldo` float NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`idcargo`, `cargo`, `sueldo`, `estado`) VALUES
(1, 'Boleteria', 1000, 1),
(2, 'Confiteria', 1200, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idcat` int(11) NOT NULL,
  `cat` varchar(250) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idcat`, `cat`, `estado`) VALUES
(1, 'Dulce', 1),
(2, 'Salado', 1),
(3, 'Bebida', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacion`
--

CREATE TABLE `clasificacion` (
  `idclasi` int(11) NOT NULL,
  `clasificacion` varchar(250) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clasificacion`
--

INSERT INTO `clasificacion` (`idclasi`, `clasificacion`, `estado`) VALUES
(1, 'APT', 1),
(2, '+14', 1),
(3, '+18', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallebutaca`
--

CREATE TABLE `detallebutaca` (
  `id` int(11) NOT NULL,
  `codbutaca` varchar(250) NOT NULL,
  `idboleta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detallebutaca`
--

INSERT INTO `detallebutaca` (`id`, `codbutaca`, `idboleta`) VALUES
(1, '3', 3),
(2, '3', 3),
(3, 'B4', 3),
(4, 'D3', 16),
(5, 'F4', 17),
(6, 'F6', 17),
(7, 'F5', 17),
(8, 'F5', 18),
(9, 'F4', 18),
(10, 'F6', 18),
(11, 'G6', 19),
(12, 'E6', 20),
(13, 'E4', 20),
(14, 'E5', 20),
(15, 'H3', 21),
(16, 'H4', 21),
(17, 'D4', 22),
(18, 'D5', 22),
(19, 'D5', 23),
(20, 'D4', 23),
(21, 'D6', 23),
(22, 'C4', 24),
(23, 'C5', 24),
(24, 'C6', 24),
(25, 'F2', 25),
(26, 'F1', 25),
(27, 'G2', 25),
(28, 'G1', 25),
(29, 'G5', 26),
(30, 'G4', 26),
(31, 'H3', 27),
(32, 'H5', 28),
(33, 'H7', 28),
(34, 'G7', 29),
(35, 'H7', 29),
(36, 'A4', 30),
(37, 'A5', 30),
(38, 'D1', 31),
(39, 'D3', 31),
(40, 'D2', 31),
(41, 'B4', 34),
(42, 'B5', 34),
(43, 'H5', 35),
(44, 'H6', 35),
(45, 'H8', 36),
(46, 'H9', 36),
(47, 'F6', 37),
(48, 'G5', 37),
(49, 'F5', 37),
(50, 'D7', 38),
(51, 'D6', 38),
(52, 'E5', 39),
(53, 'E6', 39),
(54, 'H1', 40),
(55, 'H2', 40),
(56, 'H4', 41),
(57, 'G4', 41),
(58, 'E4', 41),
(59, 'F4', 41),
(60, 'E7', 42),
(61, 'F7', 42),
(62, 'H3', 43),
(63, 'G3', 43),
(64, 'E3', 44),
(65, 'F3', 44),
(66, 'D3', 44),
(67, 'H7', 45),
(68, 'G7', 45),
(69, 'G3', 46),
(70, 'E1', 47),
(71, 'E2', 47),
(72, 'A7', 48),
(73, 'A6', 48),
(74, 'C7', 48),
(75, 'B7', 48),
(76, 'G5', 49),
(77, 'G4', 49),
(78, 'H8', 50),
(79, 'D4', 51),
(80, 'E3', 52),
(81, 'F3', 52),
(82, 'H9', 53),
(83, 'F8', 54),
(84, 'F9', 54),
(85, 'H2', 55),
(86, 'H1', 55),
(87, 'D9', 56),
(88, 'D8', 56),
(89, 'G8', 57),
(90, 'C1', 58),
(91, 'C2', 58),
(92, 'F7', 59);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleempleado`
--

CREATE TABLE `detalleempleado` (
  `id` int(11) NOT NULL,
  `idEmp` int(11) NOT NULL,
  `idboleta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalleempleado`
--

INSERT INTO `detalleempleado` (`id`, `idEmp`, `idboleta`) VALUES
(1, 2, 20),
(2, 1, 20),
(3, 1, 20),
(4, 2, 20),
(5, 1, 20),
(6, 2, 20),
(7, 2, 20),
(8, 2, 20),
(9, 2, 20),
(10, 2, 20),
(11, 2, 20),
(12, 2, 20),
(13, 2, 20),
(14, 2, 20),
(15, 2, 20),
(16, 1, 20),
(17, 1, 20),
(18, 2, 20),
(19, 2, 22),
(20, 1, 22),
(21, 1, 23),
(22, 2, 23),
(23, 1, 25),
(24, 2, 25),
(25, 1, 31),
(26, 2, 31),
(27, 1, 47),
(28, 2, 47),
(29, 2, 50),
(30, 1, 50),
(31, 1, 52),
(32, 2, 52),
(33, 2, 54),
(34, 1, 54),
(35, 1, 56),
(36, 2, 55),
(37, 2, 56),
(38, 2, 58),
(39, 1, 58),
(40, 1, 59),
(41, 2, 59);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleproducto`
--

CREATE TABLE `detalleproducto` (
  `id` int(11) NOT NULL,
  `idpro` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `costo` float NOT NULL,
  `idboleta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalleproducto`
--

INSERT INTO `detalleproducto` (`id`, `idpro`, `cantidad`, `costo`, `idboleta`) VALUES
(1, 1, 4, 45, 1),
(2, 3, 2, 21.5, 17),
(3, 6, 3, 28, 17),
(4, 1, 1, 25, 17),
(5, 5, 2, 17, 17),
(6, 4, 2, 28, 17),
(7, 2, 1, 6, 17),
(8, 2, 1, 6, 18),
(9, 1, 1, 25, 18),
(10, 4, 2, 28, 18),
(11, 3, 2, 21.5, 18),
(12, 5, 2, 17, 18),
(13, 6, 3, 28, 18),
(14, 1, 2, 43, 19),
(15, 1, 3, 6, 20),
(16, 4, 3, 64.5, 20),
(17, 6, 3, 42, 20),
(18, 1, 2, 2, 21),
(19, 6, 1, 43, 21),
(20, 4, 2, 28, 22),
(21, 1, 1, 21.5, 22),
(22, 1, 2, 43, 23),
(23, 4, 1, 14, 23),
(24, 1, 2, 43, 24),
(25, 4, 1, 14, 24),
(26, 4, 1, 14, 25),
(27, 1, 2, 43, 25),
(28, 2, 1, 17, 28),
(29, 1, 2, 43, 28),
(30, 1, 2, 43, 29),
(31, 3, 1, 14, 29),
(32, 1, 1, 21.5, 30),
(33, 1, 3, 64.5, 31),
(34, 4, 1, 14, 31),
(35, 1, 2, 43, 34),
(36, 3, 1, 14, 34),
(37, 2, 1, 17, 35),
(38, 1, 1, 21.5, 35),
(39, 1, 1, 21.5, 36),
(40, 1, 1, 21.5, 37),
(41, 1, 1, 21.5, 38),
(42, 1, 1, 21.5, 39),
(43, 2, 1, 17, 39),
(44, 1, 2, 43, 40),
(45, 1, 1, 21.5, 41),
(46, 2, 1, 17, 42),
(47, 1, 1, 21.5, 42),
(48, 1, 1, 21.5, 43),
(49, 2, 1, 17, 43),
(50, 2, 1, 17, 44),
(51, 1, 1, 21.5, 44),
(52, 2, 1, 17, 45),
(53, 1, 2, 43, 47),
(54, 4, 1, 14, 47),
(55, 1, 2, 43, 48),
(56, 1, 2, 43, 49),
(57, 4, 1, 14, 49),
(58, 1, 2, 43, 50),
(59, 4, 1, 14, 50),
(60, 2, 1, 17, 51),
(61, 1, 1, 21.5, 52),
(62, 1, 1, 21.5, 53),
(63, 1, 2, 43, 54),
(64, 4, 1, 14, 54),
(65, 1, 2, 43, 55),
(66, 1, 1, 12.5, 56),
(67, 5, 1, 21.5, 56),
(68, 1, 2, 43, 58),
(69, 4, 1, 14, 58),
(70, 6, 2, 4, 59),
(71, 5, 1, 12.5, 59);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `apellido` varchar(250) NOT NULL,
  `dni` int(8) NOT NULL,
  `edad` int(11) NOT NULL,
  `idsede` int(11) NOT NULL,
  `idcargo` int(11) NOT NULL,
  `usu` varchar(250) NOT NULL,
  `cont` varchar(250) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id`, `nombre`, `apellido`, `dni`, `edad`, `idsede`, `idcargo`, `usu`, `cont`, `estado`) VALUES
(1, 'Edmilson Yasir', 'Mendoza Miranda', 79768543, 19, 1, 1, 'edmilson', '123', 1),
(2, 'Aldair Daniel', 'Cano Francisco', 73790973, 20, 1, 2, 'aldair', '123', 1),
(3, 'Pepe', 'Martinez', 65329845, 19, 2, 1, 'pepe', '123', 1),
(4, 'Juan', 'Paredes', 98451265, 20, 2, 2, 'juan', '123', 1),
(5, 'Lucho', 'Gutierrez', 78451265, 19, 3, 1, 'lucho', '123', 1),
(6, 'Miguel', 'Gamarra', 98523215, 20, 3, 2, 'miguel', '123', 1),
(7, 'Gustavo', 'Prado', 59152615, 19, 4, 1, 'gustavo', '123', 1),
(8, 'Fernando', 'Tineo', 75246835, 20, 4, 2, 'fernando', '123', 1),
(9, 'Katy', 'Ochoa', 65321245, 19, 5, 1, 'katy', '123', 1),
(10, 'Jesus', 'Cuba', 59684826, 20, 5, 2, 'jesus', '123', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion`
--

CREATE TABLE `funcion` (
  `idfuncion` int(11) NOT NULL,
  `hora` varchar(11) NOT NULL,
  `fecha` date NOT NULL,
  `idsala` int(11) NOT NULL,
  `idpelicula` int(11) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `funcion`
--

INSERT INTO `funcion` (`idfuncion`, `hora`, `fecha`, `idsala`, `idpelicula`, `estado`) VALUES
(1, '15:00', '2021-12-27', 1, 1, 1),
(2, '18:00', '2021-12-27', 5, 2, 1),
(3, '21:00', '2021-12-27', 1, 1, 1),
(4, '21:00', '2021-11-19', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `idgen` int(11) NOT NULL,
  `genero` varchar(250) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`idgen`, `genero`, `estado`) VALUES
(1, 'Comedia', 1),
(2, 'Accion', 1),
(3, 'Terror', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `idgen` int(11) NOT NULL,
  `idclasi` int(11) NOT NULL,
  `duracion` varchar(250) NOT NULL,
  `img` varchar(250) NOT NULL,
  `trailer` varchar(250) NOT NULL,
  `estreno` date NOT NULL,
  `sinopsis` text NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`id`, `nombre`, `idgen`, `idclasi`, `duracion`, `img`, `trailer`, `estreno`, `sinopsis`, `estado`) VALUES
(1, 'Bob Esponja: Al rescate', 1, 1, '1h 31min', 'https://allcalidad.la/wp-content/uploads/2020/11/Bob-Esponja-Al-rescate-e1605892784244.jpg', 'https://www.youtube.com/watch?v=BUFKUy_c5Tw', '2021-12-27', 'Bob Esponja: Al rescate Los amigos son lo mas importante para Bob Esponja, por lo que no dudara en salir de la comodidad de su hogar en Fondo de Bikini, junto con Patricio, para adentrarse en un mundo desconocido, arriesgando sus vidas, para salvar a su amigo de la infancia, Gary, de las garras del rey Poseidon que le ha secuestrado en la Ciudad Perdida de Atlantic City.¿ Seran capaces de lograrlo?', 1),
(2, 'Rapidos y furiosos 9', 2, 2, '2h 23min', 'https://allcalidad.la/wp-content/uploads/2021/07/Fp-e1629739347257.jpg', 'https://www.youtube.com/watch?v=t3DpuQrBivU', '2021-12-27', 'Rapidos y furiosos 9 Dom Toretto (Vin Diesel) lleva una vida tranquila con Letty y su hijo, el pequeno Brian, pero saben que el peligro siempre acecha. Esta vez, esa amenaza obligara a Dom a enfrentarse a los pecados de su pasado si quiere salvar a quienes más quiere. El equipo se vuelve a reunir para impedir un complot a escala mundial, liderado por uno de los asesinos mas peligrosos y mejor conductor a los que se han enfrentado; un hombre que ademas es el hermano desaparecido de Dom, Jakob (John Cena). Novena entrega de la famosa franquicia.', 1),
(3, 'Alien: Covenant', 3, 3, '2h 2min', 'https://allcalidad.la/wp-content/uploads/2017/08/1341241324.jpg', 'https://www.youtube.com/watch?v=lLku1yEyhqI', '2021-10-01', 'Durante un viaje interplanetario, la tripulacion de la nave Covenant descubre un mundo nuevo y piensan que se trata de un lugar paradisiaco. Cuando llegan, se dan cuenta de que es un territorio aterrador, repleto de criaturas brutales.', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idpro` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `stock` int(11) NOT NULL,
  `idcat` int(11) NOT NULL,
  `precio` float NOT NULL,
  `img` varchar(250) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idpro`, `nombre`, `stock`, `idcat`, `precio`, `img`, `estado`) VALUES
(1, 'Canchita Gigante', 242, 2, 21.5, 'https://cdn.apis.cineplanet.com.pe/CDN/media/entity/get/ItemGraphic/172?allowPlaceHolder=true', 1),
(2, 'Canchita Grande', 290, 2, 17, 'https://cdn.apis.cineplanet.com.pe/CDN/media/entity/get/ItemGraphic/175?allowPlaceHolder=true', 1),
(3, 'Canchita Mediana', 294, 2, 14, 'https://cdn.apis.cineplanet.com.pe/CDN/media/entity/get/ItemGraphic/171?allowPlaceHolder=true', 1),
(4, 'Bebida Grande', 282, 3, 14, 'https://cdn.apis.cineplanet.com.pe/CDN/media/entity/get/ItemGraphic/1230?allowPlaceHolder=true', 1),
(5, 'Bebida Mediana', 294, 3, 12.5, 'https://cdn.apis.cineplanet.com.pe/CDN/media/entity/get/ItemGraphic/1221?allowPlaceHolder=true', 1),
(6, 'Sublime', 288, 1, 2, 'https://www.corporacionliderperu.com/shop/29469-large_default/sublime-chocolate-clasico-x-30-gr.jpg', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservacion`
--

CREATE TABLE `reservacion` (
  `id` int(11) NOT NULL,
  `codbutaca` varchar(10) NOT NULL,
  `idfuncion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reservacion`
--

INSERT INTO `reservacion` (`id`, `codbutaca`, `idfuncion`) VALUES
(1, 'B5', 3),
(2, 'B6', 1),
(3, 'B4', 3),
(4, 'D5', 3),
(5, 'E6', 3),
(6, 'E5', 3),
(7, 'E4', 3),
(8, 'H6', 1),
(9, 'H4', 1),
(10, 'H5', 1),
(11, '3', 3),
(12, 'G6', 1),
(13, 'H6', 3),
(14, 'G5', 3),
(15, 'G6', 3),
(16, 'G7', 3),
(17, 'E7', 3),
(18, 'E3', 3),
(19, 'D3', 3),
(20, 'F4', 1),
(21, 'F6', 1),
(22, 'F5', 1),
(23, 'F5', 1),
(24, 'F4', 1),
(25, 'F6', 1),
(26, 'G6', 2),
(27, 'E6', 1),
(28, 'E4', 1),
(29, 'E5', 1),
(30, 'H3', 3),
(31, 'H4', 3),
(32, 'D4', 1),
(33, 'D5', 1),
(34, 'D5', 2),
(35, 'D4', 2),
(36, 'D6', 2),
(37, 'C4', 1),
(38, 'C5', 1),
(39, 'C6', 1),
(40, 'F2', 1),
(41, 'F1', 1),
(42, 'G2', 1),
(43, 'G1', 1),
(44, 'G5', 1),
(45, 'G4', 1),
(46, 'H3', 1),
(47, 'H5', 3),
(48, 'H7', 3),
(49, 'G7', 1),
(50, 'H7', 1),
(51, 'A4', 1),
(52, 'A5', 1),
(53, 'D1', 1),
(54, 'D2', 1),
(55, 'D3', 1),
(56, 'B4', 1),
(57, 'B5', 1),
(58, 'H5', 2),
(59, 'H6', 2),
(60, 'H8', 3),
(61, 'H9', 3),
(62, 'F6', 2),
(63, 'G5', 2),
(64, 'F5', 2),
(65, 'D7', 1),
(66, 'D6', 1),
(67, 'E5', 2),
(68, 'E6', 2),
(69, 'H1', 1),
(70, 'H2', 1),
(71, 'H4', 2),
(72, 'G4', 2),
(73, 'E4', 2),
(74, 'F4', 2),
(75, 'E7', 1),
(76, 'F7', 1),
(77, 'H3', 2),
(78, 'G3', 2),
(79, 'E3', 2),
(80, 'F3', 2),
(81, 'D3', 2),
(82, 'H7', 2),
(83, 'G7', 2),
(84, 'G3', 1),
(85, 'E1', 1),
(86, 'E2', 1),
(87, 'A7', 1),
(88, 'A6', 1),
(89, 'C7', 1),
(90, 'B7', 1),
(91, 'G5', 4),
(92, 'G4', 4),
(93, 'H8', 1),
(94, 'D4', 3),
(95, 'E3', 1),
(96, 'F3', 1),
(97, 'H9', 1),
(98, 'F8', 1),
(99, 'F9', 1),
(100, 'H2', 3),
(101, 'H1', 3),
(102, 'D9', 3),
(103, 'D8', 3),
(104, 'G8', 1),
(105, 'C1', 1),
(106, 'C2', 1),
(107, 'F7', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `idsala` int(11) NOT NULL,
  `sala` varchar(250) NOT NULL,
  `estado` int(11) NOT NULL,
  `idsede` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`idsala`, `sala`, `estado`, `idsede`) VALUES
(1, 'SALA1 MOLINA', 1, 1),
(2, 'SALA 2 MOLINA', 1, 1),
(3, 'SALA3 MOLINA', 1, 1),
(4, 'SALA1 MSUR', 1, 2),
(5, 'SALA2 MSUR', 1, 2),
(6, 'SALA3 MSUR', 1, 2),
(7, 'SALA1 SBORJA', 1, 3),
(8, 'SALA2 SBORJA', 1, 3),
(9, 'SALA3 SBORJA', 1, 3),
(10, 'SALA1 VS', 1, 4),
(11, 'SALA2 VS', 1, 4),
(12, 'SALA3 VS', 1, 4),
(13, 'SALA1 SCLARA', 1, 5),
(14, 'SALA2 SCLARA', 1, 5),
(15, 'SALA3 SCLARA', 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sede`
--

CREATE TABLE `sede` (
  `idSede` int(11) NOT NULL,
  `Sede` varchar(250) NOT NULL,
  `Direccion` varchar(250) NOT NULL,
  `Lng` varchar(250) NOT NULL,
  `Lat` varchar(250) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sede`
--

INSERT INTO `sede` (`idSede`, `Sede`, `Direccion`, `Lng`, `Lat`, `estado`) VALUES
(1, 'CP La Molina', 'C. las Caobas, Lima 15024', '-76.9501944024438', '-12.091069093384611', 1),
(2, 'CP Mall del Sur', 'Carr. Atocongo, San Juan de Miraflores 15801', '-76.98159777315769', '-12.155811720333254', 1),
(3, 'CP San Borja', 'Jr. Ucello s/n, Cercado de Lima 15036', '-77.00523038055991', '-12.089530082588176', 1),
(4, 'CP Villa el Salvador', 'Los Ebanistas 2, Cercado de Lima 15036', '-76.93336091548568', '-12.202104026865628', 1),
(5, 'CP Santa Clara', 'Av. Nicolas Ayllon 8694', '-76.89389689397187', '-12.017282120944849', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `boleta`
--
ALTER TABLE `boleta`
  ADD PRIMARY KEY (`idboleta`),
  ADD KEY `idfun` (`idfun`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idcargo`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idcat`);

--
-- Indices de la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  ADD PRIMARY KEY (`idclasi`);

--
-- Indices de la tabla `detallebutaca`
--
ALTER TABLE `detallebutaca`
  ADD PRIMARY KEY (`id`),
  ADD KEY `codbutaca` (`codbutaca`),
  ADD KEY `idboleta` (`idboleta`);

--
-- Indices de la tabla `detalleempleado`
--
ALTER TABLE `detalleempleado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idboleta` (`idboleta`),
  ADD KEY `idEmp` (`idEmp`);

--
-- Indices de la tabla `detalleproducto`
--
ALTER TABLE `detalleproducto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idboleta` (`idboleta`),
  ADD KEY `idpro` (`idpro`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idcargo` (`idcargo`),
  ADD KEY `idsede` (`idsede`);

--
-- Indices de la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD PRIMARY KEY (`idfuncion`),
  ADD KEY `idpelicula` (`idpelicula`),
  ADD KEY `idsala` (`idsala`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`idgen`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idclasi` (`idclasi`),
  ADD KEY `idgen` (`idgen`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idpro`),
  ADD KEY `idcat` (`idcat`);

--
-- Indices de la tabla `reservacion`
--
ALTER TABLE `reservacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idfuncion` (`idfuncion`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`idsala`),
  ADD KEY `idsede` (`idsede`);

--
-- Indices de la tabla `sede`
--
ALTER TABLE `sede`
  ADD PRIMARY KEY (`idSede`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `boleta`
--
ALTER TABLE `boleta`
  MODIFY `idboleta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT de la tabla `detallebutaca`
--
ALTER TABLE `detallebutaca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT de la tabla `detalleempleado`
--
ALTER TABLE `detalleempleado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `detalleproducto`
--
ALTER TABLE `detalleproducto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `funcion`
--
ALTER TABLE `funcion`
  MODIFY `idfuncion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idpro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `reservacion`
--
ALTER TABLE `reservacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=108;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `idsala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=162;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `boleta`
--
ALTER TABLE `boleta`
  ADD CONSTRAINT `boleta_ibfk_1` FOREIGN KEY (`idfun`) REFERENCES `funcion` (`idfuncion`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `detallebutaca`
--
ALTER TABLE `detallebutaca`
  ADD CONSTRAINT `detallebutaca_ibfk_1` FOREIGN KEY (`idboleta`) REFERENCES `boleta` (`idboleta`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalleempleado`
--
ALTER TABLE `detalleempleado`
  ADD CONSTRAINT `detalleempleado_ibfk_1` FOREIGN KEY (`idboleta`) REFERENCES `boleta` (`idboleta`) ON UPDATE CASCADE,
  ADD CONSTRAINT `detalleempleado_ibfk_2` FOREIGN KEY (`idEmp`) REFERENCES `empleado` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalleproducto`
--
ALTER TABLE `detalleproducto`
  ADD CONSTRAINT `detalleproducto_ibfk_1` FOREIGN KEY (`idboleta`) REFERENCES `boleta` (`idboleta`) ON UPDATE CASCADE,
  ADD CONSTRAINT `detalleproducto_ibfk_2` FOREIGN KEY (`idpro`) REFERENCES `producto` (`idpro`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`idcargo`) REFERENCES `cargo` (`idcargo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `empleado_ibfk_2` FOREIGN KEY (`idsede`) REFERENCES `sede` (`idSede`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD CONSTRAINT `funcion_ibfk_1` FOREIGN KEY (`idsala`) REFERENCES `sala` (`idsala`) ON UPDATE CASCADE,
  ADD CONSTRAINT `funcion_ibfk_2` FOREIGN KEY (`idpelicula`) REFERENCES `pelicula` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD CONSTRAINT `pelicula_ibfk_1` FOREIGN KEY (`idgen`) REFERENCES `genero` (`idgen`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pelicula_ibfk_2` FOREIGN KEY (`idclasi`) REFERENCES `clasificacion` (`idclasi`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idcat`) REFERENCES `categoria` (`idcat`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `reservacion`
--
ALTER TABLE `reservacion`
  ADD CONSTRAINT `reservacion_ibfk_1` FOREIGN KEY (`idfuncion`) REFERENCES `funcion` (`idfuncion`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `sala_ibfk_1` FOREIGN KEY (`idsede`) REFERENCES `sede` (`idSede`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
