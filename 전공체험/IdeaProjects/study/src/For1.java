public class For1 {
    public static void main(String[] args) {
        int height = 15;
        int eyeRow = 5;
        int eyeSize = 3;

        for (int i = 1; i <= height; i++) {
            // 공백 출력
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }

            // 별 출력
            for (int j = 1; j <= 2 * i - 1; j++) {
                // 삼각형 테두리
                if (j == 1 || j == 2 * i - 1 || i == height) {
                    System.out.print("*");
                }
                // 눈 부분 (가운데 동그란 눈)
                else if (i >= eyeRow && i <= eyeRow + eyeSize + 1) {
                    int center = i;
                    int mid = (2 * i - 1) / 2 + 1;
                    int distFromCenter = Math.abs(j - mid);

                    if (i == eyeRow) {
                        // 눈 위쪽 호
                        if (distFromCenter <= 1) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    } else if (i == eyeRow + 1) {
                        // 눈 위 테두리
                        if (distFromCenter == 2) {
                            System.out.print("*");
                        } else if (distFromCenter == 0) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    } else if (i == eyeRow + 2) {
                        // 눈동자 (가운데)
                        if (distFromCenter == 3) {
                            System.out.print("*");
                        } else if (distFromCenter == 0) {
                            System.out.print("@");
                        } else {
                            System.out.print(" ");
                        }
                    } else if (i == eyeRow + 3) {
                        // 눈 아래 테두리
                        if (distFromCenter == 2) {
                            System.out.print("*");
                        } else if (distFromCenter == 0) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    } else if (i == eyeRow + eyeSize + 1) {
                        // 눈 아래쪽 호
                        if (distFromCenter <= 1) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // 바닥 밑줄
        for (int j = 1; j <= 2 * height - 1; j++) {
            System.out.print("=");
        }
        System.out.println();
    }
}