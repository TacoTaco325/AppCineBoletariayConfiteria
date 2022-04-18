<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();

    $conexion = mysqli_connect($hostname,$username,$password,$database);
    
        if(isset($_GET["idpelicula"])){

            $idpelicula = $_GET["idpelicula"];
            
            $consulta = "select p.id, p.nombre, g.genero, c.clasificacion, p.duracion, p.img, p.trailer, p.estreno, p.sinopsis from pelicula p INNER JOIN genero g on p.idgen = g.idgen INNER JOIN clasificacion c on p.idclasi = c.idclasi where p.id='{$idpelicula}'";
            $resultado = mysqli_query($conexion,$consulta);
        
            while($registro=mysqli_fetch_array($resultado)){
                $result["id"]=$registro['id'];
                $result["nombre"]=$registro['nombre'];
                $result["genero"]=$registro['genero'];
                $result["clasificacion"]=$registro['clasificacion'];
                $result["duracion"]=$registro['duracion'];
                $result["img"]=$registro['img'];
                $result["trailer"]=$registro['trailer'];
                $result["estreno"]=$registro['estreno'];
                $result["sinopsis"]=$registro['sinopsis'];

                $json['cartelera'][]=$result;

            }
            
            mysqli_close($conexion);
            echo json_encode($json);
    
    
        }else{
            $consulta = "select p.id, p.nombre, g.genero, c.clasificacion, p.duracion, p.img , p.trailer, p.estreno, p.sinopsis from pelicula p INNER JOIN genero g on p.idgen = g.idgen INNER JOIN clasificacion c on p.idclasi = c.idclasi where DATEDIFF(NOW(),p.estreno)<=7 ";
            $resultado = mysqli_query($conexion,$consulta);
        
            while($registro=mysqli_fetch_array($resultado)){
                $result["id"]=$registro['id'];
                $result["nombre"]=$registro['nombre'];
                $result["genero"]=$registro['genero'];
                $result["clasificacion"]=$registro['clasificacion'];
                $result["duracion"]=$registro['duracion'];
                $result["img"]=$registro['img'];
                $result["trailer"]=$registro['trailer'];
                $result["estreno"]=$registro['estreno'];
                $result["sinopsis"]=$registro['sinopsis'];

                $json['cartelera'][]=$result;

            }
            
            mysqli_close($conexion);
            echo json_encode($json);
        }

?>