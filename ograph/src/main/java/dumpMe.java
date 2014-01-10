import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

class Pair {
    Object a;
    Object b;

    Pair(Object a, Object b) {
        this.a = a;
        this.b = b;
    }
};

public class dumpMe {

    public static void main(String[] args) {

        List arrayList = new ArrayList();

        String fresh = "fresh";
        Pair first = new Pair("something", fresh);
        Pair pair = new Pair(first, fresh);

        arrayList.add(first);
        arrayList.add(first);
        arrayList.add(pair);
        System.out.println("------------------");
        {
            XStream xstream = new XStream();
            xstream.setMode(XStream.SINGLE_NODE_XPATH_RELATIVE_REFERENCES);
            String s = xstream.toXML(arrayList);
            System.out.println(s);
        }
        System.out.println("------------------");
        {
            XStream xstream = new XStream();
            xstream.setMode(XStream.ID_REFERENCES);
            String s = xstream.toXML(arrayList);
            System.out.println(s);

        }
        System.out.println("------------------");
        {
            XStream xstream = new XStream();
            xstream.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
            String s = xstream.toXML(arrayList);
            System.out.println(s);

        }
        System.out.println("------------------");
        {
            XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
                public HierarchicalStreamWriter createWriter(Writer writer) {
                    return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
                }
            });
            xstream.setMode(XStream.SINGLE_NODE_XPATH_RELATIVE_REFERENCES);
            String s = xstream.toXML(arrayList);
            System.out.println(s);
        }
        System.out.println("------------------");
        {
            XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
                public HierarchicalStreamWriter createWriter(Writer writer) {
                    return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
                }
            });
            xstream.setMode(XStream.ID_REFERENCES);
            String s = xstream.toXML(arrayList);
            System.out.println(s);
        }
        System.out.println("------------------");
        {
            XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
                public HierarchicalStreamWriter createWriter(Writer writer) {
                    return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
                }
            });
            xstream.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
            String s = xstream.toXML(arrayList);
            System.out.println(s);
        }
    }
}
