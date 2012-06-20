package models;

import com.mongodb.DB;
import com.mongodb.Mongo;
import play.Logger;
import play.Play;

import java.net.UnknownHostException;

/**
 * User: mguillermin
 * Date: 20/06/12
 */
public class JongoUtil {
    public static Mongo connection;

    public static org.jongo.Jongo jongo;

    static {
        try {
            connection = new Mongo(
                Play.application().configuration().getString("mongo.host"),
                Play.application().configuration().getInt("mongo.port"));
            jongo = new org.jongo.Jongo(connection.getDB(Play.application().configuration().getString("mongo.db")));
        } catch (UnknownHostException e) {
            Logger.error("Could not connect to mongodb", e);
        }
    }
}
