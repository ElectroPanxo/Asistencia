<?php
    $con = mysql_connect('localhost', 'root', '');
    $db = mysql_select_db('attendance');
    $id = (int) $_GET['id'];
    $update = mysql_query("UPDATE student SET present=100 WHERE id=1 LIMIT 1");
    mysql_close($con);
?>