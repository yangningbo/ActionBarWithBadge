package br.com.web.actionbarbadges.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    // TextView que contem os valores do badge
    private TextView badge;
    // Primitivo que contem o contador do badge
    private int quantidadeMensagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        // View que recupera uma instancia da view do item do action bar
        View menuItem = menu.findItem(R.id.email_action_bar).getActionView();
        // Instancia o text view do badge
        badge = (TextView) menuItem.findViewById(R.id.actionbar_notifcation_textview);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id == R.id.email_action_bar) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Incrementa o badge em um a cada vez que o botao incrementa e clicado
     * Se o contador estiver em mais de 99 um sinal de plus e adicionado ao badge
     * @param v
     */
    public void incrementa(View v) {
        if(quantidadeMensagens == 0) {
            badge.setVisibility(TextView.VISIBLE);
        }

        quantidadeMensagens++;
        if(quantidadeMensagens > 99) {
            badge.setText("+99");
        } else {
            badge.setText(String.valueOf(quantidadeMensagens));
        }
    }

    /**
     * Decrementa o contador do badge a cada vez que o botao decrementada e clicado
     * @param v
     */
    public void decrementa(View v) {
        quantidadeMensagens--;

        if(quantidadeMensagens <= 0) {
            badge.setVisibility(TextView.GONE);
            badge.setText("");
            quantidadeMensagens = 0;
        } else if(quantidadeMensagens > 99) {
            badge.setText("+99");
        } else {
            badge.setText(String.valueOf(quantidadeMensagens));
        }
    }
}
