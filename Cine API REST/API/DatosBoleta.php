<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();


    if(isset($_GET["idb"])){

        $idboleta = $_GET["idb"];

        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $consulta = "select B.qrboleteria, B.qrconfiteria, PE.nombre , F.fecha, F.hora, SA.sala, SE.idSede, SE.Sede  FROM boleta B INNER JOIN funcion F ON B.idfun = F.idfuncion INNER JOIN sala SA ON F.idfuncion = SA.idsala INNER JOIN pelicula PE ON F.idpelicula = PE.id INNER JOIN sede SE ON SA.idsede = SE.idsede WHERE B.idboleta = '{$idboleta}'";

        $resultado = mysqli_query($conexion,$consulta);

        while($registro=mysqli_fetch_array($resultado)){
            $result["qrboleteria"]=$registro['qrboleteria'];
            $result["qrconfiteria"]=$registro['qrconfiteria'];
            $result["nombre"]=$registro['nombre'];
            $result["fecha"]=$registro['fecha'];
            $result["hora"]=$registro['hora'];
            $result["sala"]=$registro['sala'];
            $result["idSede"]=$registro['idSede'];
            $result["Sede"]=$registro['Sede'];

            $json['boleta'][]=$result;
        //    echo $registro['id'].' - '.$registro['nombre'].' - '.$registro['profesion'].'<br/>';
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