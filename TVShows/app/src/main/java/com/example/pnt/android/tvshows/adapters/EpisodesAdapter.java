package com.example.pnt.android.tvshows.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnt.android.tvshows.R;
import com.example.pnt.android.tvshows.databinding.ItemContainerEpisodeBinding;
import com.example.pnt.android.tvshows.models.Episode;

import java.util.List;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.EpisodesViewHolder> {

    private List<Episode> episodes;
    private LayoutInflater layoutInflater;

    public EpisodesAdapter(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @NonNull
    @Override
    public EpisodesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ItemContainerEpisodeBinding itemContainerEpisodeBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.item_container_episode, parent, false
        );

        return new EpisodesViewHolder(itemContainerEpisodeBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodesViewHolder holder, int position) {
        holder.bindEpisode(episodes.get(position));
    }

    @Override
    public int getItemCount() {
        return episodes == null ? 0 : episodes.size();
    }

    static class EpisodesViewHolder extends RecyclerView.ViewHolder {
        private ItemContainerEpisodeBinding itemContainerEpisodeBinding;

        public EpisodesViewHolder(ItemContainerEpisodeBinding binding) {
            super(binding.getRoot());
            this.itemContainerEpisodeBinding = binding;
        }

        public void bindEpisode(Episode episode) {
            String title = "S";
            String season = episode.getSeason();
            if (season.length() == 1) {
                season = "0".concat(season);
            }

            String episodeNumber = episode.getEpisode();
            if (episodeNumber.length() == 1) {
                episodeNumber = "0".concat(episodeNumber);
            }

            episodeNumber = "E".concat(episodeNumber);

            title = title.concat(season).concat(episodeNumber);

            itemContainerEpisodeBinding.setTitle(title);
            itemContainerEpisodeBinding.setName(episode.getName());
            itemContainerEpisodeBinding.setAirDate(episode.getAirDate());
        }
    }
}
