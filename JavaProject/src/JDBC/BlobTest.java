package JDBC;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import java.util.ArrayList;
import java.io.*;
import javax.swing.filechooser.FileFilter;

public class BlobTest
{
	JFrame jf = new JFrame("�Ϥ��޲z�{��");
	private static Connection conn;
	private static PreparedStatement insert;
	private static PreparedStatement query;
	private static PreparedStatement queryAll;
	// �w�q�@��DefaultListModel����
	private DefaultListModel<ImageHolder> imageModel
		= new DefaultListModel<>();
	private JList<ImageHolder> imageList = new JList<>(imageModel);
	private JTextField filePath = new JTextField(26);
	private JButton browserBn = new JButton("...");
	private JButton uploadBn = new JButton("�W��");
	private JLabel imageLabel = new JLabel();
	// �H���e���|�إ��ɮ׿�ܾ�
	JFileChooser chooser = new JFileChooser(".");
	// �إ��ɮ׹L�o��
	ExtensionFileFilter filter = new ExtensionFileFilter();
	static
	{
		try
		{
			Properties props = new Properties();
			props.load(new FileInputStream("mysql.ini"));
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pass = props.getProperty("pass");
			Class.forName(driver);
			// �����Ʈw�s��
			conn = DriverManager.getConnection(url , user , pass);
			// �إ߰��洡�J��PreparedStatement����A
			// �Ӫ�����洡�J��i�H��^�۰ʲ��ͪ��D��
			insert = conn.prepareStatement("insert into img_table"
				+ " values(null,?,?)" , Statement.RETURN_GENERATED_KEYS);
			// �إߨ��PreparedStatement����A�Ω�d�߫��w�Ϥ��A�d�ߩҦ��Ϥ�
			query = conn.prepareStatement("select img_data from img_table"
				+ " where img_id=?");
			queryAll = conn.prepareStatement("select img_id, "
				+ " img_name from img_table");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void init()throws SQLException
	{
		// -------��l���ɮ׿�ܾ�--------
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.setDescription("�Ϥ���(*.jpg,*.jpeg,*.gif,*.png)");
		chooser.addChoosableFileFilter(filter);
		// �T��u�ɮ������v�U�ԦC������ܡu�Ҧ��ɮסv�ﶵ�C
		chooser.setAcceptAllFileFilterUsed(false);
		// ---------��l�Ƶ{������---------
		fillListModel();
		filePath.setEditable(false);
		// �u����
		imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel jp = new JPanel();
		jp.add(filePath);
		jp.add(browserBn);
		browserBn.addActionListener(event -> {
			// ����ɮ׹�ܤ��
			int result = chooser.showDialog(jf , "�s���Ϥ��ɤW��");
			// �p�G�ϥΪ̿�ܤFAPPROVE�]�֭�^���s�A�Y�}�ҡA�x�s���ī��s
			if(result == JFileChooser.APPROVE_OPTION)
			{
				filePath.setText(chooser.getSelectedFile().getPath());
			}
		});
		jp.add(uploadBn);
		uploadBn.addActionListener(avt -> {
			// �p�G�W���ɮת���r��������e
			if (filePath.getText().trim().length() > 0)
			{
				// �N���w�ɮצs����Ʈw
				upload(filePath.getText());
				// �M�Ť�r������e
				filePath.setText("");
			}
		});
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		left.add(new JScrollPane(imageLabel) , BorderLayout.CENTER);
		left.add(jp , BorderLayout.SOUTH);
		jf.add(left);
		imageList.setFixedCellWidth(160);
		jf.add(new JScrollPane(imageList) , BorderLayout.EAST);
		imageList.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// �p�G�ƹ�����
				if (e.getClickCount() >= 2)
				{
					// ���X�����List����
					ImageHolder cur = (ImageHolder)imageList.
					getSelectedValue();
					try
					{
						// ��ܿ�����ع�����Image
						showImage(cur.getId());
					}
					catch (SQLException sqle)
					{
						sqle.printStackTrace();
					}
				}
			}
		});
		jf.setSize(620, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	// ----------�M��img_table��RListModel----------
	public void fillListModel()throws SQLException
	{

		try(
			// ����d��
			ResultSet rs = queryAll.executeQuery())
		{
			// ���M���Ҧ�����
			imageModel.clear();
			// ��d�ߪ������O���K�[��ListModel��
			while (rs.next())
			{
				imageModel.addElement(new ImageHolder(rs.getInt(1)
					,rs.getString(2)));
			}
		}
	}
	// ---------�N���w�Ϥ���J��Ʈw---------
	public void upload(String fileName)
	{
		// �I���ɦW
		String imageName = fileName.substring(fileName.lastIndexOf('\\')
			+ 1 , fileName.lastIndexOf('.'));
		File f = new File(fileName);
		try(
			InputStream is = new FileInputStream(f))
		{
			// �]�m�Ϥ��W�Ѽ�
			insert.setString(1, imageName);
			// �]�m�G�i���y�Ѽ�
			insert.setBinaryStream(2, is , (int)f.length());
			int affect = insert.executeUpdate();
			if (affect == 1)
			{
				// ���s��sListModel�A�N�|��JList��̷ܳs���Ϥ��C��
				fillListModel();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// ---------�ھڹϤ�ID����ܹϤ�----------
	public void showImage(int id)throws SQLException
	{
		// �]�m�Ѽ�
		query.setInt(1, id);
		try(
			// ����d��
			ResultSet rs = query.executeQuery())
		{
			if (rs.next())
			{
				// ���XBlob��
				Blob imgBlob = rs.getBlob(1);
				// ���XBlob��̪����
				ImageIcon icon=new ImageIcon(imgBlob.getBytes(1L
					,(int)imgBlob.length()));
				imageLabel.setIcon(icon);
			}
		}
	}
	public static void main(String[] args)throws SQLException
	{
		new BlobTest().init();
	}
}
// �إ�FileFilter���l���O�A�ΥH��@�ɮ׹L�o�\��
class ExtensionFileFilter extends FileFilter
{
	private String description = "";
	private ArrayList<String> extensions = new ArrayList<>();
	// �ۭq��k�A�Ω�K�[�ɮװ��ɦW
	public void addExtension(String extension)
	{
		if (!extension.startsWith("."))
		{
			extension = "." + extension;
			extensions.add(extension.toLowerCase());
		}
	}
	// �Ω�]�m���ɮ׹L�o�����y�z��r
	public void setDescription(String aDescription)
	{
		description = aDescription;
	}
	// �~��FileFilter���O������@����H��k�A��^���ɮ׹L�o�����y�z��r
	public String getDescription()
	{
		return description;
	}
	// �~��FileFilter���O������@����H��k�A�P�_���ɮ׹L�o���O�_�������ɮ�
	public boolean accept(File f)
	{
		// �p�G���ɮ׬O���|�A�������ɮ�
		if (f.isDirectory()) return true;
		// �N�ɦW�ର�p�g�]�����ର�p�g�����A�Ω󩿲��ɦW�j�p�g�^
		String name = f.getName().toLowerCase();
		// �M���Ҧ��i���������ɦW�A�p�G���ɦW�ۦP�A���ɮ״N�i�����C
		for (String extension : extensions)
		{
			if (name.endsWith(extension))
			{
				return true;
			}
		}
		return false;
	}
}
// �إߤ@��ImageHolder���O�A�Ω�ʸ˹Ϥ��W�B�Ϥ�ID
class ImageHolder
{
	// �ʸ˹Ϥ���ID
	private int id;
	// �ʸ˹Ϥ����Ϥ��W�r
	private String name;
	public ImageHolder(){}
	public ImageHolder(int id , String name)
	{
		this.id = id;
		this.name = name;
	}
	// id��setter�Mgetter��k
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}
	// name��setter�Mgetter��k
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	// �мgtoString��k�A��^�Ϥ��W
	public String toString()
	{
		return name;
	}
}