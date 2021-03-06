package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class JComboTest04 extends JFrame {
  JTextField tf;

  public static void main(String[] args) {
    JComboTest04 w = new JComboTest04( "JComboTest04" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 220 );
    w.setVisible( true );
  }
  public JComboTest04( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();

    tf = new JTextField();

    String[] choice = { "0000", "1111", "2222", "3333", "4444", "5555" };
    JComboBox combo = new JComboBox( choice );
    combo.addPopupMenuListener( new MyPopupListener() );
    combo.addActionListener( new MyActionListener() );
    combo.addItemListener( new MyItemListener() );

    pane.add( combo, BorderLayout.NORTH );
    pane.add( tf, BorderLayout.SOUTH );

    tf.setBorder( new TitledBorder( "選択された項目" ) );
    combo.setBorder( new LineBorder( Color.black, 2 ) );
  }

  class MyPopupListener implements PopupMenuListener {
    @Override
    public void popupMenuWillBecomeVisible( PopupMenuEvent e ){
      System.out.println( "ポップアップメニューが表示されました　popupMenuWillBecomeVisible()" );
    }
    @Override
    public void popupMenuWillBecomeInvisible( PopupMenuEvent e ){
      System.out.println( "ポップアップメニューが非表示になりました  popupMenuWillBecomeInvisible()" );
    }
    @Override
    public void popupMenuCanceled( PopupMenuEvent e ){
      //このメソッドは呼ばれない
      System.out.println( "ポップアップメニューがキャンセルされました" );
    }
  }

  class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent e ){
      System.out.println( "Actionイベントが通知されました  actionPerformed()" );
    }
  }
  class MyItemListener implements ItemListener {
    @Override
    public void itemStateChanged( ItemEvent e ){

      if( e.getStateChange()==ItemEvent.SELECTED ){
        System.out.println( "itemイベント　選択されました  itemStateChanged() ItemEvent.SELECTED" );
      }
      else{
        System.out.println( "itemイベント　選択解除されました    itemStateChanged() ItemEvent.DESELECTED" );
      }
      JComboBox combo = (JComboBox)e.getSource();
      int selectNo = combo.getSelectedIndex();
      String select = (String)combo.getSelectedItem();
      tf.setText( selectNo +": "+ select );
   }
 }
}
