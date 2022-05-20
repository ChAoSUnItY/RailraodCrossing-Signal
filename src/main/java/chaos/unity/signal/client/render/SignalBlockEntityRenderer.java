package chaos.unity.signal.client.render;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Matrix4f;

import java.awt.*;

public abstract class SignalBlockEntityRenderer {
    public abstract float[][][] getPrecalculatedVertexes();

    protected void renderSignalLight(VertexConsumer consumer, Matrix4f matrixPos, Direction direction, Color color) {
        var vec = getPrecalculatedVertexes()[direction.getHorizontal()];

        for (var i = 0; i < 4; i++)
            consumer.vertex(matrixPos, vec[i][0], vec[i][1], vec[i][2])
                    .color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha())
                    .next();
    }
}
