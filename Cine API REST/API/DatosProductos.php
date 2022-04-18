<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();


    if(isset($_GET["idb"])){

        $idboleta = $_GET["idb"];

        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $consulta = "select P.nombre, dp.cantidad FROM boleta B INNER JOIN detalleproducto dp on B.idboleta = dp.idboleta INNER JOIN producto P ON dp.idpro = P.idpro WHERE B.idboleta = '{$idboleta}'";

        $resultado = mysqli_query($conexion,$consulta);

        while($registro=mysqli_fetch_array($resultado)){
            $result["nombre"]=$registro['nombre'];
            $result["cantidad"]=$registro['cantidad'];

            $json['producto'][]=$result;
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