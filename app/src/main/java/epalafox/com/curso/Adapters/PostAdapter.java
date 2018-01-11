package epalafox.com.curso.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import epalafox.com.curso.Models.PostModel;
import epalafox.com.curso.R;

/**
 * Created by epalafox on 15/08/2017.
 */
//Esta clase extiende el Adaptador Base
public class PostAdapter extends BaseAdapter {
    //Contenedor de Posts
    private ArrayList<PostModel> posts;
    //Inflador de diseño
    private LayoutInflater layoutInflater;
    //Constructor del adaptador con el que asignamos el listado y el inflador del diseño
    public PostAdapter(Context activityContext, ArrayList<PostModel> postArray)
    {
        this.layoutInflater = LayoutInflater.from(activityContext);
        this.posts = postArray;
    }
    //Obtenemos el total de elementos en el arreglo
    @Override
    public int getCount() {
        return posts.size();
    }
    //Obtiene el post en el indice i
    @Override
    public Object getItem(int i) {
        return posts.get(i);
    }
    //Obtiene el indice i
    @Override
    public long getItemId(int i) {
        return i;
    }
    //Generamos la vista personalizada de nuestro Post
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ContenedorView contenedorView = null;
        if(view == null)
        {
            //Inflamos el diseño
            view = layoutInflater.inflate(R.layout.post_adapter,null);
            //Inicializamos el contenedor
            contenedorView = new ContenedorView();
            //Inicializamos las vistas
            contenedorView.postText = (TextView)view.findViewById(R.id.postText);
            contenedorView.commentsText = (TextView)view.findViewById(R.id.postComments);
            contenedorView.dateText = (TextView)view.findViewById(R.id.postDate);
            //Obtenemos el Post en el indice que estamos llenando
            PostModel postModel = posts.get(i);
            //Damos el valor a los controles
            contenedorView.postText.setText(postModel.getPost());
            //Tenemos que convertir el entero a String debido a que el método sobrecargado que recibe entero carga los recursos con ese índice
            contenedorView.commentsText.setText(Integer.toString(postModel.getComments().size()));
            contenedorView.dateText.setText(postModel.getDate() + " " + postModel.getHour());
            //Por último le damos el valor al Tag del view, esto nos servira obtener los datos del post en cualquier momento
            view.setTag(postModel);
            return view;
        }
        return view;
    }
    private class ContenedorView
    {
        TextView postText;
        TextView commentsText;
        TextView dateText;
    }
}
