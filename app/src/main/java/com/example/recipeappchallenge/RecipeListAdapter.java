package com.example.recipeappchallenge;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    /*
Vengono dichiarate due variabili private: mRecipes, che rappresenta la lista delle ricette da visualizzare nell'adapter,
e mInflater, un oggetto LayoutInflater utilizzato per creare le viste per gli elementi della RecyclerView.
 */
    private final ArrayList<RecipeList> mRecipes;
    private LayoutInflater mInflater;

    public RecipeListAdapter(Context context, ArrayList<RecipeList> recipes) {
        this.mRecipes = recipes;
        this.mInflater = LayoutInflater.from(context);
    }

    /*
    Il metodo onCreateViewHolder viene chiamato quando è necessario creare un nuovo ViewHolder.
    Qui viene inflata la vista recipelist_item da utilizzare come layout per gli elementi della RecyclerView e
    viene creata un'istanza del ViewHolder RecypeViewHolder, passando la vista appena creata.
     */
    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View recipeItemView = mInflater.inflate(R.layout.recipelist_item, parent, false);

        return new RecipeViewHolder(recipeItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        // Recupero l'oggetto RecipeList corrente dalla lista mRecipes utilizzando l'indice position
        RecipeList mCurrentRecipe = mRecipes.get(position);
        // Imposto il testo del titolo e della descrizione nel ViewHolder utilizzando i dati dell'oggetto mCurrentRecipe
        holder.mTitle.setText(mCurrentRecipe.getTitle());
        holder.mDescription.setText(mCurrentRecipe.getDescription());
    }

    /*
    Il metodo getItemCount restituisce il numero di elementi nella lista delle ricette, che determina la lunghezza della RecyclerView.
     */
    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    /*
    La classe RecypeViewHolder estende RecyclerView.ViewHolder ed è responsabile di tenere riferimento agli elementi della vista (i TextView per il titolo e la descrizione) e all'adapter.
    La vista viene trovata utilizzando i metodi findViewById all'interno del costruttore del ViewHolder.
     */
    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final RecipeListAdapter mAdapter;
        final TextView mTitle, mDescription, mText, mIngredients;
        final ImageView imageView;

        public RecipeViewHolder(@NonNull View itemView, RecipeListAdapter adapter) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_recipe);
            mTitle = itemView.findViewById(R.id.textView_title);
            mDescription = itemView.findViewById(R.id.textView_description);
            mText = itemView.findViewById(R.id.textView_detailText);
            mIngredients = itemView.findViewById(R.id.textView_detailIngredients);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Ottieni la posizione dell'elemento selezionato
            int mPosition = getLayoutPosition();
            if(mPosition != RecyclerView.NO_POSITION) {
                RecipeList currentRecipe = mRecipes.get(mPosition);

                // Ottieni il contesto dell'itemView
                Context context = itemView.getContext();

                // Avvia la nuova attività (RecipeDetailActivity) passando i dati della voce selezionata
                Intent intent = new Intent(context, RecipeDetailActivity.class);
                intent.putExtra("image", currentRecipe.getImage());
                intent.putExtra("title", currentRecipe.getTitle());
                intent.putExtra("text", currentRecipe.getText());
                intent.putExtra("ingredients", currentRecipe.getIngredients());
                context.startActivity(intent);
            }
        }
    }
}
