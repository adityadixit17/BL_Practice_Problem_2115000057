import java.util.*;
class User {
    int userId;
    String name;
    int age;
    List<Integer> friends; 
    User next;
    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}
class SocialMedia {
    User head = null;
    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }
    void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            if (!user1.friends.contains(userId2)) {
                user1.friends.add(userId2);
            }
            if (!user2.friends.contains(userId1)) {
                user2.friends.add(userId1);
            }
        }
    }
    void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friends.remove(Integer.valueOf(userId2));
            user2.friends.remove(Integer.valueOf(userId1));
        }
    }
    List<Integer> findMutualFriends(int userId1, int userId2) {
        List<Integer> mutualFriends = new ArrayList<>();
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            for (int friendId1 : user1.friends) {
                if (user2.friends.contains(friendId1)) {
                    mutualFriends.add(friendId1);
                }
            }
        }
        return mutualFriends;
    }
    void displayAllFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + " (User ID: " + userId + "): ");
            for (int friendId : user.friends) {
                System.out.println("Friend ID: " + friendId);
            }
        }
    }
    User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    User findUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    int countFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            return user.friends.size();
        }
        return 0;
    }
    void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}
public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();
        socialMedia.addUser(1, "Khushi", 25);
        socialMedia.addUser(2, "Piyush", 30);
        socialMedia.addUser(3, "Pooja", 22);
        socialMedia.addUser(4, "Krishna", 28);
        socialMedia.addFriendConnection(1, 2);
        socialMedia.addFriendConnection(1, 3);
        socialMedia.addFriendConnection(2, 4);
        socialMedia.displayAllFriends(1);
        socialMedia.displayAllFriends(2);
        System.out.println("Mutual friends between Khushi and Piyush: " + socialMedia.findMutualFriends(1, 2));
        System.out.println("Friends count for Khushi: " + socialMedia.countFriends(1));
        socialMedia.removeFriendConnection(1, 2);
        socialMedia.displayAllFriends(1);
        socialMedia.displayAllFriends(2);
        System.out.println("All users in the system:");
        socialMedia.displayAllUsers();
    }
}
