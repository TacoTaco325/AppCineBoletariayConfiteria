<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();


    if(isset($_GET["sede"],$_GET["id"])){

        $Sede = $_GET["sede"];
        $id = $_GET["id"];


        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $consulta = "select f.idfuncion, f.hora from funcion f INNER JOIN sala s on f.idsala = s.idsala INNER JOIN sede l on s.idsede = l.idSede INNER JOIN pelicula p ON f.idpelicula=p.id WHERE l.idSede = (SELECT idsede FROM sede where sede = '{$Sede}') and p.id='{$id}' and f.fecha = Curdate()";
        $resultado = mysqli_query($conexion,$consulta);


        while($registro=mysqli_fetch_array($resultado)){
            $result["idfuncion"]=$registro['idfuncion'];
            $result["hora"]=$registro['hora'];

            $json['funcion'][]=$result;
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