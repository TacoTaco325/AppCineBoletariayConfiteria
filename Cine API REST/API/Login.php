<?php 
    $hostname = "localhost";
    $database = "dbcine";
    $username = "root";
    $password = "";

    $json=array();


    if(isset($_GET["usu"],$_GET["cont"])){

        $usu = $_GET["usu"];
        $cont = $_GET["cont"];


        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $consulta = "select e.id, e.nombre,e.apellido,e.dni,e.edad,s.idSede,s.Sede, c.idcargo, c.cargo from empleado e INNER JOIN Sede s ON e.idsede = s.idSede INNER JOIN cargo c ON c.idcargo = e.idcargo where e.usu ='{$usu}' and e.cont='{$cont}'";
        $resultado = mysqli_query($conexion,$consulta);


        while($registro=mysqli_fetch_array($resultado)){
            $result["id"]=$registro['id'];
            $result["nombre"]=$registro['nombre'];
            $result["apellido"]=$registro['apellido'];
            $result["dni"]=$registro['dni'];
            $result["edad"]=$registro['edad'];
            $result["idSede"]=$registro['idSede'];
            $result["Sede"]=$registro['Sede'];
            $result["idcargo"]=$registro['idcargo'];
            $result["cargo"]=$registro['cargo'];

            $json['empleado'][]=$result;
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