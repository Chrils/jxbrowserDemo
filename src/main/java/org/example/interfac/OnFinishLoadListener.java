package org.example.interfac;

import com.teamdev.jxbrowser.chromium.events.*;

public interface OnFinishLoadListener extends LoadListener {

    @Override
    default void onDocumentLoadedInFrame(FrameLoadEvent frameLoadEvent) {}

    @Override
    default void onDocumentLoadedInMainFrame(LoadEvent loadEvent) {}

    @Override
    default void onFailLoadingFrame(FailLoadingEvent failLoadingEvent) {}

    @Override
    default void onProvisionalLoadingFrame(ProvisionalLoadingEvent provisionalLoadingEvent) {}

    @Override
    default void onStartLoadingFrame(StartLoadingEvent startLoadingEvent) {}
}
