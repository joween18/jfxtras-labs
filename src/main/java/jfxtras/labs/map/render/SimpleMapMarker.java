package jfxtras.labs.map.render;

import java.awt.Point;
import java.util.Collections;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.RadialGradientBuilder;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;

/**
 * A simple implementation of the {@link MapMarkable} interface. Each map marker is painted as a circle with a black
 * border line and filled with a specified color.
 *
 * @author Jan Peter Stotz
 *
 */
public class SimpleMapMarker extends AbstractMapMarker {

    private Circle sphere;

    private int radius;

    public SimpleMapMarker(double lat, double lon) {
        this(10, Color.YELLOW, lat, lon);
    }

    public SimpleMapMarker(int radius, Color color, double lat, double lon) {
        super(lat, lon);
        this.radius = radius;

        this.sphere = CircleBuilder.create()
            .centerX(radius)
            .centerY(radius)
            .radius(radius)
            .cache(true)
            .build();

        RadialGradient rgrad = RadialGradientBuilder.create()
            .centerX(sphere.getCenterX() - sphere.getRadius() / 3)
            .centerY(sphere.getCenterY() - sphere.getRadius() / 3)
            .radius(sphere.getRadius())
            .proportional(false)
            .stops(new Stop(0.0, color), new Stop(1.0, Color.BLACK))
            .build();

        sphere.setFill(rgrad);
        sphere.setEffect(createShadow(Color.rgb(50, 50, 50, 0.7)));

    }

    @Override
    List<? extends Node> createChildren(Point position){
        sphere.setTranslateX(position.x - this.radius);
        sphere.setTranslateY(position.y - this.radius);
        return Collections.singletonList(sphere);
    }

    @Override
    public Node getNode() {
        return sphere;
    }
}
