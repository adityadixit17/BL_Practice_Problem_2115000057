class TextState {
    String text;
    TextState prev;
    TextState next;
    TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}
class TextEditor {
    TextState head;
    TextState tail;
    TextState current;
    int historySize;
    int currentSize;
    TextEditor(int historySize) {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.historySize = historySize;
        this.currentSize = 0;
    }
    void addTextState(String newText) {
        TextState newState = new TextState(newText);
        if (current != null) {
            current.next = newState;
            newState.prev = current;
            current = newState;
        } else {
            head = newState;
            tail = newState;
            current = newState;
        }
        if (currentSize < historySize) {
            currentSize++;
        } else {
            head = head.next;
            head.prev = null;
        }
    }
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }
    void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("No text available.");
        }
    }
    void displayAllStates() {
        TextState temp = head;
        while (temp != null) {
            System.out.println(temp.text);
            temp = temp.next;
        }
    }
}
public class UndoRedoTextEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        editor.addTextState("Hello");
        editor.addTextState("Hello, World!");
        editor.addTextState("Hello, World! How are you?");
        editor.addTextState("Hello, World! How are you? I'm fine.");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
