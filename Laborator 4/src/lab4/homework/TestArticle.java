package lab4.homework;

import com.sun.security.jgss.GSSUtil;

public class TestArticle {
    public static void main(String[] args) {
        Article[] articles = new Article[3];
        articles[0] = new Article("Mouse", 23.2, 2);
        articles[1] = new Article("MousePad", 5.2, 3);
        articles[2] = new Article("Printer", 58.8, 1);

        for(int i=0; i < articles.length; i++){
            System.out.println(articles[i].getArticleDetails().getName());
            System.out.println("->");
            System.out.println(articles[i].getArticleDetails().getUnitPrice());
        }
    }
}
