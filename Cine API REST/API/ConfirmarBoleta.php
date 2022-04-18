<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();

    if(isset($_GET["ide"],$_GET["idb"],$_GET["cargo"])){

        $idEmp = $_GET["ide"];
        $idboleta = $_GET["idb"];
        $cargo = $_GET["cargo"];

        if($cargo == 1){

            $conexion = mysqli_connect($hostname,$username,$password,$database);
            $insert = "insert INTO detalleempleado(idEmp, idboleta) VALUES ('{$idEmp}','{$idboleta}')";
            $resultado_insert = mysqli_query($conexion,$insert);

            //echo ("Registro en resersaiones");
            if($resultado_insert){
                $update = "update boleta SET qrboleteria = 1 WHERE idboleta = '{$idboleta}'";
                $resultado_update = mysqli_query($conexion,$update);
                if($resultado_update){
                    $result["mensaje"]="Se confirmo la boleta correctamente";

                    $json['boleta'][]=$result;
                    echo json_encode($json);
                }else{
                    echo ("Error en actualizar QR de boleteria");
                }
            }else{
                echo ("No se registro Empleado");
            }

        }elseif($cargo == 2){

            $conexion = mysqli_connect($hostname,$username,$password,$database);
            $insert = "insert INTO detalleempleado(idEmp, idboleta) VALUES ('{$idEmp}','{$idboleta}')";
            $resultado_insert = mysqli_query($conexion,$insert);

            //echo ("Registro en resersaiones");
            if($resultado_insert){
                $update = "update boleta SET qrconfiteria  = 1 WHERE idboleta = '{$idboleta}'";
                $resultado_update = mysqli_query($conexion,$update);
                if($resultado_update){
                    $result["mensaje"]="Se confirmo la boleta correctamente";

                    $json['boleta'][]=$result;
                    echo json_encode($json);

                }else{
                    echo ("Error en actualizar QR de confiteria");
                }

            }else{
                echo ("No se registro Empleado");
            }

        }


    }else{
        $resultar["success"]=0;
        $resultar["message"]='Ws no Retorna';
        $json['funcion'][]=$resultar;
        echo json_encode($json);
    }

?>