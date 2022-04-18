<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();


    if(isset($_GET["hora"],$_GET["idpel"])){

        $hora = $_GET["hora"];
        $idpelicula = $_GET["idpel"];

        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $consulta = "select f.idfuncion, s.sala FROM funcion f INNER JOIN sala s on f.idsala=s.idsala WHERE f.hora = '{$hora}' and f.idpelicula = '{$idpelicula}' and f.fecha = Curdate()";
        $resultado = mysqli_query($conexion,$consulta);


        while($registro=mysqli_fetch_array($resultado)){
            $result["idfuncion"]=$registro['idfuncion'];
            $result["sala"]=$registro['sala'];

            $json['funcion'][]=$result;
        //    echo $registro['id'].' - '.$registro['nombre'].' - '.$registro['profesion'].'<br/>';
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