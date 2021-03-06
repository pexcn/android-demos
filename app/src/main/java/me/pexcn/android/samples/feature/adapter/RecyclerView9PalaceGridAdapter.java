package me.pexcn.android.samples.feature.adapter;

import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import me.pexcn.android.samples.R;

/**
 * Created by pexcn on 2017-03-30.
 * <p>
 * FIXME: notifyChange
 */
@SuppressWarnings("WeakerAccess")
public class RecyclerView9PalaceGridAdapter extends RecyclerView.Adapter<RecyclerView9PalaceGridAdapter.ViewHolder> {
    private ArrayList<Uri> mUris;

    public RecyclerView9PalaceGridAdapter(ArrayList<Uri> uris) {
        mUris = uris;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_9_palace_grid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(v, holder.getAdapterPosition());
                }
            });
        }

        if (mUris != null && position < mUris.size()) {
            holder.mImageView.setImageURI(mUris.get(position));
            if (holder.mImageView.getVisibility() != View.VISIBLE) {
                holder.mImageView.setVisibility(View.VISIBLE);
            }
            if (holder.mDelete.getVisibility() != View.VISIBLE) {
                holder.mDelete.setVisibility(View.VISIBLE);
            }
        } else {
            holder.mImageView.setImageDrawable(ContextCompat.getDrawable(holder.mImageView.getContext(), R.drawable.ic_action_add_photo));
            if (holder.mImageView.getVisibility() != View.VISIBLE) {
                holder.mImageView.setVisibility(View.VISIBLE);
            }
            if (holder.mDelete.getVisibility() != View.GONE) {
                holder.mDelete.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mUris == null) {
            return 1;
        }
        if (mUris.size() >= 9) {
            return mUris.size();
        }
        return mUris.size() + 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public ImageView mDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mDelete = (ImageView) itemView.findViewById(R.id.delete);
        }
    }

    public void add(Uri uri) {
        mUris.add(uri);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        mUris.remove(position);
        notifyDataSetChanged();
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
