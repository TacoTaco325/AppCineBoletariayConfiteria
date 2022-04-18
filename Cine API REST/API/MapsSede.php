<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();

    $conexion = mysqli_connect($hostname,$username,$password,$database);
    $consulta = "select Sede , Lng , Lat from sede";
    $resultado = mysqli_query($conexion,$consulta);

    while($registro=mysqli_fetch_array($resultado)){
        $result["Sede"]=$registro['Sede'];
        $result["Lng"]=$registro['Lng'];
        $result["Lat"]=$registro['Lat'];
        $json['sede'][]=$result;
        //    echo $registro['id'].' - '.$registro['nombre'].' - '.$registro['profesion'].'<br/>';
        }

    mysqli_close($conexion);
    echo json_encode($json);

?>