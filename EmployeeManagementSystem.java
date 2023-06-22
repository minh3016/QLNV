import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class EmployeeManagementSystem {
    private Connection connection;
    private JFrame frame;
    private JButton addButton;
    private JButton searchButton;
    private JButton exitButton;

    public EmployeeManagementSystem() {
        connectToDatabase();

        // Form1: Quản lý nhân viên
        frame = new JFrame("Quản lý nhân viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridBagLayout());

        addButton = new JButton("ADD");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddForm();
            }
        });

        searchButton = new JButton("SEARCH");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openSearchForm();
            }
        });

        exitButton = new JButton("EXIT");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        frame.add(addButton, gbc);

        gbc.gridy = 1;
        frame.add(searchButton, gbc);

        gbc.gridy = 2;
        frame.add(exitButton, gbc);
    }

    private Connection connectToDatabase() {
        Connection connection = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/QLNV";
            String username = "root";
            String password = "123456";

            // Thay đổi thông tin kết nối cơ sở dữ liệu tại đây
            connection = DriverManager.getConnection(URL, username, password);

            if (connection != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }


    private void openAddForm() {
        frame.dispose();

        JFrame addFrame = new JFrame("Thêm nhân viên");
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.setSize(400, 300);
        addFrame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(12, 2));

        JLabel idLabel = new JLabel("Mã nhân viên");
        JTextField idField = new JTextField();

        JLabel nameLabel = new JLabel("Họ và tên");
        JTextField nameField = new JTextField();

        JLabel dobLabel = new JLabel("Ngày sinh");
        JTextField dobField = new JTextField();

        JLabel genderLabel = new JLabel("Giới tính");
        JTextField genderField = new JTextField();

        JLabel addressLabel = new JLabel("Địa chỉ");
        JTextField addressField = new JTextField();

        JLabel phoneLabel = new JLabel("Số điện thoại");
        JTextField phoneField = new JTextField();

        JLabel idCardLabel = new JLabel("Số căn cước công dân");
        JTextField idCardField = new JTextField();

        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();

        JLabel positionLabel = new JLabel("Vị trí làm việc");
        JTextField positionField = new JTextField();

        JLabel startDateLabel = new JLabel("Ngày bắt đầu làm việc");
        JTextField startDateField = new JTextField();

        JLabel endDateLabel = new JLabel("Ngày kết thúc làm việc");
        JTextField endDateField = new JTextField();

        JLabel salaryLabel = new JLabel("Tiền lương");
        JTextField salaryField = new JTextField();

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(dobLabel);
        inputPanel.add(dobField);
        inputPanel.add(genderLabel);
        inputPanel.add(genderField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        inputPanel.add(idCardLabel);
        inputPanel.add(idCardField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(positionLabel);
        inputPanel.add(positionField);
        inputPanel.add(startDateLabel);
        inputPanel.add(startDateField);
        inputPanel.add(endDateLabel);
        inputPanel.add(endDateField);
        inputPanel.add(salaryLabel);
        inputPanel.add(salaryField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                // Lấy các giá trị từ các trường khác và thực hiện thêm vào cơ sở dữ liệu

                // Tiến hành thêm vào cơ sở dữ liệu

                // Sau khi thêm thành công, hiển thị thông báo và quay trở lại form1
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
                addFrame.dispose();
                frame.setVisible(true);
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
                frame.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(exitButton);

        addFrame.add(inputPanel, BorderLayout.CENTER);
        addFrame.add(buttonPanel, BorderLayout.SOUTH);
        addFrame.setVisible(true);
    }

    private void openSearchForm() {
        frame.dispose();

        JFrame searchFrame = new JFrame("Tìm kiếm và sửa nhân viên");
        searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchFrame.setSize(400, 300);
        searchFrame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel idLabel = new JLabel("Mã nhân viên");
        JTextField idField = new JTextField(10);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();

                // Truy vấn cơ sở dữ liệu để tìm kiếm nhân viên có mã nhân viên trùng khớp
                // Hiển thị thông tin nhân viên trong form
                // Nếu không tìm thấy, hiển thị thông báo "Nhập sai mã nhân viên"
            }
        });

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(searchButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy thông tin từ các trường trong form
                // Thực hiện cập nhật thông tin nhân viên vào cơ sở dữ liệu

                // Hiển thị thông báo cập nhật thành công
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Thực hiện xóa nhân viên khỏi cơ sở dữ liệu

                // Hiển thị thông báo xóa thành công
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchFrame.dispose();
                frame.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);

        searchFrame.add(inputPanel, BorderLayout.NORTH);
        searchFrame.add(buttonPanel, BorderLayout.SOUTH);
        searchFrame.setVisible(true);
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        system.display();
    }
}
