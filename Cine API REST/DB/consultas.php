<?php

    include 'conexion.php';

    class Consultas{
        private $con;

        function __construct()
        {
            $this->con = Conexion::conectar();
        }

        function ListarPelicula(){

            $this->con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

            $resultado = null;

            $consulta = "select p.id, p.nombre, g.genero, c.clasificacion, p.duracion, p.estreno, p.sinopsis from pelicula p INNER JOIN genero g on p.idgen = g.idgen INNER JOIN clasificacion c on p.idclasi = c.idclasi where DATEDIFF(NOW(),p.estreno)<=7";

            $query = $this->con->prepare($consulta);
            $query->execute();
            while ($filas = $query->fetchall(PDO::FETCH_ASSOC)){
                $resultado = $filas;
            }

            /*$query = $this->con->prepare($consulta);
            $query->execute();*/

            

            /*while ($filas = $query->fetchall(PDO::FETCH_ASSOC)){
                $resultado = $filas;
            }*/

            $this->co = Conexion::desconectar();

            if($resultado == null){ 
                $resultado['mensaje'] = "No";
                return $resultado;
            }
            else{
                return $resultado;
            }
        }
    }

?>