import javax.swing.JOptionPane;

public class Input {
    public static void main(String[] args) {
        // Menampilkan dialog input
        String pelajaran = JOptionPane.showInputDialog(null, 
            "Anda sedang belajar apa?", 
            "Input", 
            JOptionPane.QUESTION_MESSAGE);

        // Menampilkan dialog pesan jika input tidak kosong
        if (pelajaran != null) {
            JOptionPane.showMessageDialog(null, 
                "Belajar " + pelajaran + " sangat mudah", 
                "Message", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}