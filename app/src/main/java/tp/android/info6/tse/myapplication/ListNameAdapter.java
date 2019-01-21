package tp.android.info6.tse.myapplication;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListNameAdapter extends RecyclerView.Adapter<ListItemViewHolder> {
    private List<String> nameList;
    private final NameItemListener nameItemListener;

    public ListNameAdapter(NameItemListener nameItemListener) {
        nameList = new ArrayList<>();
        this.nameItemListener = nameItemListener;

    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_name,viewGroup, false);
        return new ListItemViewHolder(view, nameItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder listItemViewHolder, int i) {
        listItemViewHolder.setContent(nameList.get(i));

    }

    @Override
    public int getItemCount() {

        return nameList.size();
    }

    public void updateData(List<String> nameList){
        this.nameList.clear();
        this.nameList.addAll(nameList);

        notifyDataSetChanged();
    }
}
