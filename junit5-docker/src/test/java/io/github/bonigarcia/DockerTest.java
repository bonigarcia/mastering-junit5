
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.github.junit5docker.Docker;
import com.github.junit5docker.Environment;
import com.github.junit5docker.Port;
import com.github.junit5docker.WaitFor;

@Docker(image = "mysql", ports = @Port(exposed = 8801, inner = 3306), environments = {
        @Environment(key = "MYSQL_ROOT_PASSWORD", value = "root"),
        @Environment(key = "MYSQL_DATABASE", value = "testdb"),
        @Environment(key = "MYSQL_USER", value = "testuser"),
        @Environment(key = "MYSQL_PASSWORD", value = "secret"), }, waitFor = @WaitFor("mysqld: ready for connections"))
class DockerTest {

    @Disabled
    @Test
    void test() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://192.168.99.100:8801/testdb", "testuser",
                "secret");
        assertFalse(connection.isClosed());
        connection.close();
    }

}
