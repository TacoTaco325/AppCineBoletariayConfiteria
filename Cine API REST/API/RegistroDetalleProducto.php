<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";



    if(isset($_GET["idpro"],$_GET["cant"],$_GET["costo"],$_GET["idb"])){

        $idpro = $_GET["idpro"];
        $cantidad = $_GET["cant"];
        $costo = $_GET["costo"];
        $idboleta = $_GET["idb"];

        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $insert = "insert into detalleproducto(idpro,cantidad,costo,idboleta) VALUES ('{$idpro}','{$cantidad}','{$costo}','{$idboleta}')";
        $resultado_insert = mysqli_query($conexion,$insert);

        //echo ("Registro en resersaiones");
        if($resultado_insert){
            $sql = "update producto SET stock=stock -'{$cantidad}' where idpro={$idpro}";
            $resultado = mysqli_query($conexion,$sql);

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
            $resultar["message"]='no ';
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