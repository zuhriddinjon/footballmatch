package uz.instat.footballmatch.ui.match.movie;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import uz.instat.footballmatch.R;

public class MatchMovieFragment extends Fragment {
    private static final String KEY_URL = "key_url";
    private static final String PLAYBACK_TIME = "play_time";

    private ProgressBar pbLoad;
    private VideoView videoView;
    private String url;

    private MediaController controller;
    private int mCurrentPosition = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        if (getArguments() != null) {
            url = getArguments().getString(KEY_URL, "");
        }

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
        }
        controller = new MediaController(requireContext());
    }

    public static MatchMovieFragment newInstance(String url) {
        MatchMovieFragment fragment = new MatchMovieFragment();

        Bundle args = new Bundle();
        args.putString(KEY_URL, url);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_movie, container, false);
        videoView = view.findViewById(R.id.video_view);
        pbLoad = view.findViewById(R.id.pb_video);

        controller.setMediaPlayer(videoView);
        videoView.setMediaController(controller);
        controller.setAnchorView(videoView);
//        initializePlayer();
        return view;
    }

    @Override

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        if (savedInstanceState != null) {
//            mCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
//        }
//        MediaController controller = new MediaController(requireContext());
//        controller.setMediaPlayer(videoView);
//        videoView.setMediaController(controller);
//        initializePlayer();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PLAYBACK_TIME, videoView.getCurrentPosition());
    }

    @Override
    public void onStart() {
        super.onStart();

        pbLoad.setVisibility(View.VISIBLE);
        initializePlayer();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            videoView.pause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releasePlayer();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }

    private void initializePlayer() {
        Uri videoUri = getMedia(url);
        videoView.setVideoURI(videoUri);

        videoView.setOnPreparedListener(
                mediaPlayer -> {
                    if (mCurrentPosition > 0) {
                        videoView.seekTo(mCurrentPosition);
                    } else {
                        videoView.seekTo(1);
                    }
                    videoView.start();
                    pbLoad.setVisibility(View.GONE);
                });

        videoView.setOnCompletionListener(
                mediaPlayer -> {
                    Toast.makeText(requireContext(),
                            "hello",
                            Toast.LENGTH_SHORT).show();

                    videoView.seekTo(0);
                });
    }


    private void releasePlayer() {
        videoView.stopPlayback();
    }

    private Uri getMedia(String mediaName) {
        if (URLUtil.isValidUrl(mediaName)) {
            return Uri.parse(mediaName);
        } else {
            return Uri.parse("android.resource://" + requireActivity().getPackageName() +
                    "/raw/" + mediaName);

        }
    }

}
