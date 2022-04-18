<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();


    if(isset($_GET["idb"])){

        $idboleta = $_GET["idb"];

        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $consulta = "select db.codbutaca FROM boleta B INNER JOIN detallebutaca db on B.idboleta = db.idboleta WHERE B.idboleta = '{$idboleta}'";

        $resultado = mysqli_query($conexion,$consulta);

        while($registro=mysqli_fetch_array($resultado)){
            $result["codbutaca"]=$registro['codbutaca'];

            $json['butaca'][]=$result;
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