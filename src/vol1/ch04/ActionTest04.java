package vol1.ch04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionTest04 extends JFrame {

  public static void main(String[] args) {
    ActionTest04 w = new ActionTest04( "ActionTest04" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 200 );
    w.setVisible( true );
  }
  public ActionTest04( String title ){
    super( title );

    JPanel pane = (JPanel)getContentPane();

    JToolBar toolbar = new JToolBar();
    pane.add( toolbar, BorderLayout.NORTH );

    toolbar.add( new OpenAction() );
    toolbar.add( new SaveAction() );
    toolbar.addSeparator();
    toolbar.add( new ExitAction() );

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    JMenu menu = new JMenu( "ファイル" );
    menuBar.add( menu );

    menu.add( new OpenAction() );
    menu.add( new SaveAction() );
    menu.addSeparator();
    menu.add( new ExitAction() );

  }

  class OpenAction extends AbstractAction {
    OpenAction(){
      putValue( Action.SMALL_ICON, new ImageIcon( "open.gif" ) );
      putValue( Action.NAME, "開く" );
      putValue( Action.SHORT_DESCRIPTION, "開く" );
    }
    public void actionPerformed( ActionEvent e ){
      System.out.println( "Open" );
    }
  }

  class SaveAction extends AbstractAction {
    SaveAction(){
      putValue( Action.SMALL_ICON, new ImageIcon( "save.gif" ) );
      putValue( Action.NAME, "保存" );
      putValue( Action.SHORT_DESCRIPTION, "保存" );
    }
    public void actionPerformed( ActionEvent e ){
      System.out.println( "Save" );
    }
  }

  class ExitAction extends AbstractAction {
    ExitAction(){
      putValue( Action.SMALL_ICON, new ImageIcon( "exit.gif" ) );
      putValue( Action.NAME, "終了" );
      putValue( Action.SHORT_DESCRIPTION, "終了" );
    }
    public void actionPerformed( ActionEvent e ){
      System.out.println( "Exit" );
    }
  }

}
