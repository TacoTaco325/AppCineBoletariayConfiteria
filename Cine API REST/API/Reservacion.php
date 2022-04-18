<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();


    if(isset($_GET["id"])){

        $id = $_GET["id"];
 
        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $consulta = "select R.codbutaca, R.idfuncion, s.sala FROM funcion F INNER JOIN reservacion R ON F.idfuncion = R.idfuncion INNER JOIN sala s ON s.idsala=f.idsala WHERE F.idfuncion = '{$id}'";
        $resultado = mysqli_query($conexion,$consulta);


        while($registro=mysqli_fetch_array($resultado)){
            $result["codbutaca"]=$registro['codbutaca'];
            $result["idfuncion"]=$registro['idfuncion'];
            $result["sala"]=$registro['sala'];

            $json['reservacion'][]=$result;
        //    echo $registro['id'].' - '.$registro['nombre'].' - '.$registro['profesion'].'<br/>';
        }

        mysqli_close($conexion);
        echo json_encode($json);


    }else{

        $resultar["success"]=0;
        $resultar["message"]='Ws no Retorna';
        $json['reservacion'][]=$resultar;
        echo json_encode($json);

    }