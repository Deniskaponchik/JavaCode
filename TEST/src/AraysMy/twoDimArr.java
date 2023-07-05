package AraysMy;

public class twoDimArr {

    int height;
    int width;


    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        char[][] matrix = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = '.';
            }
        }

        /*
        //Рисуем все кусочки змеи
        //Голова
        matrix[snake.getSections().get(0).getY()][snake.getSections().get(0).getX()] = 'X';

        //Тело
        for (int i = 1; i < snake.getSections().size(); i++) {
            matrix[snake.getSections().get(i).getY()][snake.getSections().get(i).getX()] = 'x';
        }
        //Рисуем мышь
        matrix[mouse.getY()][mouse.getX()]='^';
        //Выводим все это на экран
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
         */
    }


}
