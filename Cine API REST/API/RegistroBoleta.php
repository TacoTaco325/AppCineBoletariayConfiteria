<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();


    if(isset($_GET["fecha"],$_GET["hora"],$_GET["total"],$_GET["idfun"],$_GET["correo"])){

        $fecha = $_GET["fecha"];
        $hora = $_GET["hora"];
        $total = $_GET["total"];
        $idfun = $_GET["idfun"];
        $correo = $_GET["correo"];

        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $insert = "insert INTO boleta(fecha, hora, total, idfun,correo) VALUES ('{$fecha}','{$hora}','{$total}','{$idfun}','{$correo}')";
        $resultado_insert = mysqli_query($conexion,$insert);


        if($resultado_insert){
            $consulta = "select MAX(idboleta) from boleta ";
            $resultado = mysqli_query($conexion,$consulta);

            while($registro=mysqli_fetch_array($resultado)){
                $result["id"]=$registro['MAX(idboleta)'];
    
                $json['boleta'][]=$result;
            //    echo $registro['id'].' - '.$registro['nombre'].' - '.$registro['profesion'].'<br/>';
            }

            mysqli_close($conexion);
            echo json_encode($json);

        }else{
            $resultar["success"]=0;
            $resultar["message"]='Ws no Retorna';
            $json['boleta'][]=$resultar;
            echo json_encode($json);
        }
    }else{
        $resultar["success"]=0;
        $resultar["message"]='Ws no Retorna';
        $json['boleta'][]=$resultar;
        echo json_encode($json);
    }

?>
