package screenControl;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import drop2048.Scroll;
import drop2048.Scroll.ScrollItem;

public class InfoScreen extends AbstractScreen {
	private Scroll scroll;
	private TextButton backButton;
	private static ScrollItem[] items;
	/**
	 * Constructor.
	 */
    public InfoScreen() {       
            super();
            setBackground("background/bg.png");
            scroll = new Scroll(true, initializeInfo());
            createButtons();
            createTable();
            initializeInfo();
    }
    
    /**
     * Crea los botones con las distintas opciones.
     */
    private void createButtons() {
    	 // Botón para volver a la pantalla anterior
    	backButton = new TextButton("Back", getSkin());
    	
    	backButton.addListener(new InputListener() { 
		    @Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) { 
		        game.setScreen(new MenuScreen());
		        return false;
		    } 
		} );
    }
    
    /**
	 * Crea la tabla con los botones.
	 */
    private void createTable(){
    	table = super.getTable();
    	table.center().bottom();
    	table.add("Blocks Information").colspan(4);
    	table.row();
    	table.add().height(h*0.02f);
    	table.row();
    	table.add(scroll).size(w*0.9f, h*0.65f).colspan(4);
    	table.row();
    	table.add().height(h*0.02f);
    	table.row();
    	table.add(backButton).size(w*0.4f, h*0.07f).colspan(4);
    	table.row();
    	table.add().size(0,h*0.1f);
    }
    
    public ScrollItem[] initializeInfo() {
    	if(items == null) {
    		items = new ScrollItem[5];
    		items[0] = new ScrollItem(new Vector3(2, 6, 5), "Catch the numbers with the same color and number than yours.");
    		items[1] = new ScrollItem(11, "Get a random number");
    		items[2] = new ScrollItem(13, "Return to 2, 3 or 5 depending on the difficulty");
    		items[3] = new ScrollItem(12, "Decrease speed");
    		items[4] = new ScrollItem(14, "Increase speed");
    	}

       return items;
    }
}