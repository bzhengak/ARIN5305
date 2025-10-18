package robot_collisions;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class HighCoverageTest {

    @Test
    public void testNoCollision() {
        Solution solution = new Solution();
        // 测试没有碰撞的情况：所有机器人都向右移动
        int[] positions = {1, 2, 3};
        int[] healths = {10, 20, 30};
        String directions = "RRR";
        List<Integer> result = solution.survivedRobotsHealths(positions, healths, directions);
        assertEquals(3, result.size());
        assertEquals(10, (int) result.get(0));
        assertEquals(20, (int) result.get(1));
        assertEquals(30, (int) result.get(2));
    }

    @Test
    public void testAllCollisions() {
        Solution solution = new Solution();
        // 测试所有机器人都碰撞的情况：左侧机器人向右，右侧机器人向左
        int[] positions = {1, 2, 3};
        int[] healths = {10, 20, 30};
        String directions = "RLR";
        List<Integer> result = solution.survivedRobotsHealths(positions, healths, directions);
        assertEquals(2, result.size());
        assertEquals(9, (int) result.get(0));  // 原位置0的机器人(健康度10)击败位置1的机器人(健康度20)，剩余健康度9
        assertEquals(30, (int) result.get(1)); // 原位置2的机器人(健康度30)未参与战斗
    }

    @Test
    public void testComplexCollisions() {
        Solution solution = new Solution();
        // 测试复杂的碰撞序列
        int[] positions = {1, 2, 3, 4};
        int[] healths = {5, 20, 20, 30};
        String directions = "RLRL";
        List<Integer> result = solution.survivedRobotsHealths(positions, healths, directions);
        assertEquals(2, result.size());
        assertEquals(15, (int) result.get(0)); // 机器人0(5)与机器人1(20)碰撞，剩余15
        assertEquals(10, (int) result.get(1)); // 机器人2(20)与机器人3(30)碰撞，剩余10
    }

    @Test
    public void testEqualHealthCollision() {
        Solution solution = new Solution();
        // 测试相同健康度的机器人碰撞
        int[] positions = {1, 2};
        int[] healths = {10, 10};
        String directions = "RL";
        List<Integer> result = solution.survivedRobotsHealths(positions, healths, directions);
        assertEquals(0, result.size()); // 两者都被摧毁
    }

    @Test
    public void testChainCollision() {
        Solution solution = new Solution();
        // 测试连锁碰撞
        int[] positions = {1, 2, 3};
        int[] healths = {1, 10, 1};
        String directions = "RRL";
        List<Integer> result = solution.survivedRobotsHealths(positions, healths, directions);
        assertEquals(1, result.size());
        assertEquals(9, (int) result.get(0)); // 机器人1(10)击败机器人2(1)，然后被机器人0(1)攻击，剩余9
    }
}