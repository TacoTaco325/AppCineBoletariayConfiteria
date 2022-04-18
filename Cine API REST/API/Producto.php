<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();

    $conexion = mysqli_connect($hostname,$username,$password,$database);
    $consulta = "select idpro, nombre, stock, idcat, precio, img FROM producto where stock>50";
    $resultado = mysqli_query($conexion,$consulta);


    while($registro=mysqli_fetch_array($resultado)){
        $result["idpro"]=$registro['idpro'];
        $result["nombre"]=$registro['nombre'];
        $result["stock"]=$registro['stock'];
        $result["idcat"]=$registro['idcat'];
        $result["precio"]=$registro['precio'];
        $result["img"]=$registro['img'];

        $json['producto'][]=$result;
        //    echo $registro['id'].' - '.$registro['nombre'].' - '.$registro['profesion'].'<br/>';
    }

    mysqli_close($conexion);
    echo json_encode($json);


?>