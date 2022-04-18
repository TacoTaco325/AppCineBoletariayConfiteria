<?php

    class Conexion{

        private static $dbName = "dbcine";
        private static $dbHost = "localhost";
        private static $user = "root";
        private static $pass = "";

        private static $cont = null;
        
        public static function conectar(){
            if(null == static::$cont){ //self::$cont = $this->cont
                try{
                    self::$cont = new PDO("mysql:host=".self::$dbHost.";"."dbname=".self::$dbName, self::$user, self::$pass);//$cont ahora es un objeto
                }
                catch(PDOException $e){
                    die($e->getMessage());
                }
            }
            return self::$cont;
        }

        public static function desconectar(){
            self::$cont = null;
        }

    }

?>