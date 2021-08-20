/**
 * problem: generate a valid html header with all the tags correctly closed using "len" character of an html paragraph.
 */
import java.util.LinkedList;

class TagInfo {
    int pos;
    String tag;

    TagInfo(int pos, String tag) {
        this.pos = pos;
        this.tag = tag;
    }
}
public class HtmlShortener {

    public static void main(String[] args) {

        String result = shortener("<html><body><h1><img />My First Heading</h1><p>My first paragraph.</p></body></html>", 10);
        System.out.println(result.equals("<html><body><h1>My First H</h1></body></html>"));


        String result2 = shortener("<html><body><h1>My First Heading</h1><p>My first paragraph.</p></body></html>", 20);
        System.out.println(result2.equals("<html><body><h1>My First Heading</h1><p>My f</p></body></html>"));

        String result4 = shortener("<html><body><h1>My First Heading</h1><p>My first paragraph.</p></body></html>", 35);
        System.out.println(result4.equals("<html><body><h1>My First Heading</h1><p>My first paragraph.</p></body></html>"));
        
        String result3 = shortener("<html><body><h1>My First Heading</h1><p>My first paragraph.</p></body></html>", 3);
        System.out.println(result3.equals("<html><body><h1>My </h1></body></html>"));


        String result5 = shortener("<html><body><h1>My First Heading</h1><p>My first paragraph.</p></body></html>", 50);
        System.out.println(result5.equals("<html><body><h1>My First Heading</h1><p>My first paragraph.</p></body></html>"));

    }

    private static TagInfo getTagInfo(int index, String html) {
        int pos = index + 1;
        StringBuilder tag = new StringBuilder();
        while (html.charAt(pos) != '>') {
            if (html.charAt(pos) != '/') {
                tag.append(html.charAt(pos));
            }
            pos++;
        }

        return new TagInfo(pos, tag.toString());
    }

    public static String shortener(String html, int len) {
        StringBuilder sb = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();
        int count = 0;
        int i = 0;

        while (i < html.length()) {
            // base case 
            if (count == len) {
                break;
            }
            if (html.charAt(i) == '<') {
                // open tag
                if (html.charAt(i + 1) != '/') {
                    TagInfo info = getTagInfo(i, html);
                    sb.append("<" + info.tag + ">");
                    stack.push(info.tag);
                    i = info.pos;

                // close tag
                } else {
                    TagInfo info = getTagInfo(i, html);
                    sb.append("</" + info.tag + ">");
                    stack.pop();
                    i = info.pos;
                }
            } else {
                sb.append(html.charAt(i));
                count++;
            }
            i++;
        }

        // leftover unclosed tags
        while (!stack.isEmpty()) {
            String tag = stack.pop();
            sb.append("</" + tag + ">");
        }

        return sb.toString();
    }
}