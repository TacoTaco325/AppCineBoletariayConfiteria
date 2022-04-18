<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();


    if(isset($_GET["nom"])){

        $nom = $_GET["nom"];

        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $consulta = "select Sede , Lng , Lat from sede where Sede ='{$nom}'";
        $resultado = mysqli_query($conexion,$consulta);

        while($registro=mysqli_fetch_array($resultado)){
            $result["Sede"]=$registro['Sede'];
            $result["Lng"]=$registro['Lng'];
            $result["Lat"]=$registro['Lat'];
            $json['sede'][]=$result;
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