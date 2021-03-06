package com.rujirakongsomran.scenelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.esri.arcgisruntime.layers.ArcGISSceneLayer;
import com.esri.arcgisruntime.mapping.ArcGISScene;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.Camera;
import com.esri.arcgisruntime.mapping.view.SceneView;

public class MainActivity extends AppCompatActivity {
    private SceneView mSceneView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a scene and add a basemap to it
        ArcGISScene scene = new ArcGISScene();
        scene.setBasemap(Basemap.createImagery());

        mSceneView = (SceneView) findViewById(R.id.sceneView);
        mSceneView.setScene(scene);

        // add a scene service to the scene for viewing buildings
        ArcGISSceneLayer sceneLayer = new ArcGISSceneLayer(getResources().getString(R.string.brest_buildings));
        scene.getOperationalLayers().add(sceneLayer);

        // add a camera and initial camera position
        Camera camera = new Camera(48.378, -4.494, 200, 345, 65, 0);
        mSceneView.setViewpointCamera(camera);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // pause SceneView
        mSceneView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // resume SceneView
        mSceneView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // dispose SceneView
        mSceneView.dispose();
    }
}
