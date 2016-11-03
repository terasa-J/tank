import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.event.*;
public class TreeDemo extends JFrame{
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	private JTree tree;
//	private JTextArea textArea;
	private JPanel p;
	public TreeDemo(){
//	    super("TreeBrowserTest");//ʵ�����������ڵ�
	    root = makeSampleTree();//ʵ����������ģ��
	    model = new DefaultTreeModel (root);
	    tree = new JTree(model);
//	    tree.addTreeSelectionListener(this);
//	    tree. getSelectionModel().setSelectionMode(
//	    		TreeSelectionModel.SINGLE_TREE_SELECTION);
	    p = new JPanel();
	    p.add(new JScrollPane(tree));
//	    textArea = new JTextArea();
//	    p.add(new JScrollPane(textArea));
	    this.add(p);
	    this.setSize(400,300);
	 //   this.setLocation(100,100);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public DefaultMutableTreeNode makeSampleTree() {
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("����");
	DefaultMutableTreeNode country = new DefaultMutableTreeNode("�й�");
	root.add(country);
	DefaultMutableTreeNode state = new DefaultMutableTreeNode("ɽ��");
	country.add(state);
	DefaultMutableTreeNode city = new DefaultMutableTreeNode("�ൺ");
	state.add(city);
	city = new DefaultMutableTreeNode("����");
	state.add(city);
	state = new DefaultMutableTreeNode("����");
	country.add(state);
	city = new DefaultMutableTreeNode("�Ͼ�");
	state.add(city);
	return root;
}	

public static void main(String[] args) {
	 TreeDemo f = new TreeDemo();
	 f.setVisible(true);

 }

}
	    