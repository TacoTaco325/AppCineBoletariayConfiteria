<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();


    if(isset($_GET["idpelicula"])){

        $idpelicula = $_GET["idpelicula"];


        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $consulta = "select DISTINCT l.Sede from funcion f INNER JOIN sala s on f.idsala = s.idsala INNER JOIN sede l on s.idsede = l.idSede INNER JOIN pelicula p ON f.idpelicula=p.id WHERE f.idpelicula='{$idpelicula}' and f.fecha = Curdate()";
        $resultado = mysqli_query($conexion,$consulta);


        while($registro=mysqli_fetch_array($resultado)){
            $result["sede"]=$registro['Sede'];

            $json['funcion'][]=$result;
        }

        mysqli_close($conexion);
        echo json_encode($json);


    }else{
        $resultar["success"]=0;
        $resultar["message"]='Ws no Retorna';
        $json['funcion'][]=$resultar;
        echo json_encode($json);
    }

?>