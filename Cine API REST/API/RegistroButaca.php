<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";



    if(isset($_GET["cod"],$_GET["idf"],$_GET["idb"])){

        $codbutaca = $_GET["cod"];
        $idfuncion = $_GET["idf"];
        $idboleta = $_GET["idb"];

        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $insert = "insert into reservacion(codbutaca,idfuncion) values('{$codbutaca}','{$idfuncion}')";
        $resultado_insert = mysqli_query($conexion,$insert);

        $consulta = "insert into detallebutaca(codbutaca,idboleta) values('{$codbutaca}','{$idboleta}')";
        $resultado = mysqli_query($conexion,$consulta);

        if($resultado_insert){
            if($resultado){
                $resultar["message"]='ok';
                $json['reservacion'][]=$resultar;
                echo json_encode($json);
            }else{
                $resultar["message"]='no';
                $json['reservacion'][]=$resultar;
                echo json_encode($json);
            }

        }else{
            $resultar["message"]='no re';
                $json['reservacion'][]=$resultar;
                echo json_encode($json);
        }

    }else{
        $resultar["success"]=0;
        $resultar["message"]='Ws no Retorna';
        $json['funcion'][]=$resultar;
        echo json_encode($json);
    }

?>