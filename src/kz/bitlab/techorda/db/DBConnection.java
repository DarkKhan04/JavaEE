package kz.bitlab.techorda.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {
    public static Connection connection;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tech_orda_db",
                    "root",
                    "root");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Book> getBooks(){
        ArrayList<Book> books = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT b.id, b.name, b.genre, b.price, b.description, b.author_id, a.firstName, a.lastName, a.instagram " +
                    "FROM books b " +
                    "INNER JOIN authors a " +
                    "ON b.author_id=a.id " +
                    "ORDER BY b.price DESC");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setGenre(resultSet.getString("genre"));
                book.setPrice(resultSet.getDouble("price"));
                book.setDescription(resultSet.getString("description"));

                Author author = new Author();
                author.setId(resultSet.getInt("author_id"));
                author.setFirstName(resultSet.getString("firstName"));
                author.setLastName(resultSet.getString("lastName"));
                author.setInstagram(resultSet.getString("instagram"));

                book.setAuthor(author);

                books.add(book);
            }

            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }

    public static void addBook(Book book){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO books(name, author_id, genre, price, description) " +
                    "VALUES (?, ?, ?, ?, ?)");

            statement.setString(1, book.getName());
            statement.setInt(2, book.getAuthor().getId());
            statement.setString(3, book.getGenre());
            statement.setDouble(4, book.getPrice());
            statement.setString(5, book.getDescription());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Book getBook(int id){
        Book book = null;
        Author author = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT b.id, b.name, b.genre, b.price, b.description, b.author_id, a.firstName, a.lastName, a.instagram " +
                    "FROM books b " +
                    "INNER JOIN authors a " +
                    "ON b.author_id=a.id " +
                    "WHERE b.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();


            if(resultSet.next()){
                book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setGenre(resultSet.getString("genre"));
                book.setPrice(resultSet.getDouble("price"));
                book.setDescription(resultSet.getString("description"));

                author = new Author();
                author.setFirstName(resultSet.getString("firstName"));
                author.setLastName(resultSet.getString("lastName"));
                author.setId(resultSet.getInt("author_id"));
                author.setInstagram(resultSet.getString("instagram"));

                book.setAuthor(author);

                statement.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    public static void updateBook(Book book){
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE books SET " +
                    "name = ?, " +
                    "author_id = ?, " +
                    "genre = ?, " +
                    "price = ?, " +
                    "description = ? " +
                    "WHERE id = ?"
            );

            statement.setString(1, book.getName());
            statement.setInt(2, book.getAuthor().getId());
            statement.setString(3, book.getGenre());
            statement.setDouble(4, book.getPrice());
            statement.setString(5, book.getDescription());
            statement.setInt(6, book.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteBook(int id){
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Author> getAuthors(){
        ArrayList<Author> authors = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM authors ORDER BY firstName");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Author author = new Author();
                author.setId(resultSet.getInt("id"));
                author.setFirstName(resultSet.getString("firstName"));
                author.setLastName(resultSet.getString("lastName"));
                author.setInstagram(resultSet.getString("instagram"));
                authors.add(author);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return authors;
    }

    public static Author getAuthor(int id){
        Author author = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM authors WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                author = new Author();
                author.setFirstName(resultSet.getString("firstName"));
                author.setLastName(resultSet.getString("lastName"));
                author.setInstagram(resultSet.getString("instagram"));
                author.setId(resultSet.getInt("id"));
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return author;
    }

    public static void addAuthor(Author author){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO authors(firstName, lastName, instagram) " +
                    "VALUES (?, ?, ?)");

            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.setString(3, author.getInstagram());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static User getUser(String email){
        User user = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole_id(resultSet.getInt("role_id"));
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(User user){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users(email, password, full_name, role_id) " +
                    "VALUES  (?, ?, ?, ?)");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFull_name());
            statement.setInt(4, user.getRole_id());
            statement.executeUpdate();
            statement.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean checkUser(String email){
        boolean ok = false;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users " +
                    "WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                ok = true;
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    public static void deleteUser(User user){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM users WHERE email = ?");
            statement.setString(1, user.getEmail());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addNews(News news){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO news (title, content, post_date, user_id) " +
                    "VALUES (?, ?, NOW(), ?)");
            statement.setString(1, news.getTitle());
            statement.setString(2, news.getContent());
            statement.setLong(3, news.getUser().getId());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<News> getNews(){
        ArrayList<News> news = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.id, n.title, n.content, n.user_id, u.full_name, n.post_date " +
                    "FROM news n " +
                    "INNER JOIN users u ON u.id = n.user_id " +
                    "ORDER BY n.post_date DESC");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                News n = new News();

                n.setId(resultSet.getLong("id"));
                n.setTitle(resultSet.getString("title"));
                n.setContent(resultSet.getString("content"));
                n.setPostDate(resultSet.getTimestamp("post_date"));

                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setFull_name(resultSet.getString("full_name"));
                n.setUser(user);

                news.add(n);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return news;
    }
    public static News getNewsById(Long id){
        News news = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.id, n.title, n.content, n.user_id, u.full_name, n.post_date " +
                    "FROM news n " +
                    "INNER JOIN users u ON u.id = n.user_id " +
                    "WHERE n.id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                news = new News();

                news.setId(resultSet.getLong("id"));
                news.setTitle(resultSet.getString("title"));
                news.setContent(resultSet.getString("content"));
                news.setPostDate(resultSet.getTimestamp("post_date"));

                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setFull_name(resultSet.getString("full_name"));
                news.setUser(user);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return news;
    }
    public static void updateNews(News news){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE news SET " +
                    "title=?, content=? " +
                    "WHERE id=?");
            statement.setString(1, news.getTitle());
            statement.setString(2, news.getContent());
            statement.setLong(3, news.getId());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addComment(Comment comment){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO comments(user_id, news_id, comment, post_date) " +
                    "VALUES (?, ?, ?, NOW())");
            statement.setLong(1, comment.getUser().getId());
            statement.setLong(2, comment.getNews().getId());
            statement.setString(3, comment.getComment());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Comment> getComments(Long newsId){
        ArrayList<Comment> comments = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT co.id, co.news_id, co.user_id, co.comment, co.post_date, u.full_name " +
                    "FROM comments co " +
                    "INNER JOIN users u ON u.id = co.user_id " +
                    "WHERE co.news_id = ? " +
                    "ORDER BY co.post_date DESC");
            statement.setLong(1, newsId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Comment comment = new Comment();
                User user = new User();
                News news = new News();
                news.setId(resultSet.getLong("news_id"));
                user.setId(resultSet.getLong("user_id"));
                user.setFull_name(resultSet.getString("full_name"));
                comment.setId(resultSet.getLong("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPostDate(resultSet.getTimestamp("post_date"));
                comment.setUser(user);
                comment.setNews(news);

                comments.add(comment);
            }

            statement.executeQuery();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return comments;
    }
}
