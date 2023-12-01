package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "Testing Code")
public class Testing_Code extends OpMode {

    @Override
    public void init() {
        //clawL.setPosition(.5);
        //clawR.setPosition(.5);
        //ML ml = new ML(Opmode);//Cu f***ed this up
        //ml.iniit();

        ML.leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ML.leftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ML.rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ML.rightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Say", "Hello Driver");
    }

    @Override
    public void loop() {

        double y = (1.4142135624 * gamepad1.left_stick_y) /2;
        double x = (1.4142135624 * gamepad1.left_stick_x) /2;
        double s = gamepad1.right_stick_x;

        ML.leftFront.setPower(y - x - s);
        ML.leftRear.setPower(y + x - s);
        ML.rightFront.setPower(y + x + s);
        ML.rightRear.setPower(y - x + s);

        if (gamepad1.left_bumper) {
            ML.intake.setPower(1);
        } else if (gamepad1.right_bumper) {
            ML.intake.setPower(-1);
        } else {
            ML.intake.setPower(0);
        }
        /*
        if (gamepad1.dpad_up) {
            liftL.setPower(.6);
            liftR.setPower(.6);
        } else if (gamepad1.dpad_down) {
            liftL.setPower(-.6);
            liftR.setPower(-.6);
        } else {
            liftL.setPower(0);
            liftR.setPower(0);
        }
        */
        if (gamepad1.a) {
            ML.arm.setPower(1);
        } else if(gamepad1.b) {
            ML.arm.setPower(-1);
        } else {
            ML.arm.setPower(0);
        }

        if (gamepad1.x) {
            ML.rotate.setPower(1);
        }
        else if (gamepad1.y) {
            ML.rotate.setPower(-1);
        } else {
            ML.rotate.setPower(0);
        }
        /*
        if (gamepad1.b) {
            clawL.setPosition(.45);
            clawR.setPosition(.55);
        } else {
            clawL.setPosition(.5);
            clawR.setPosition(.5);
        }

        if (gamepad1.x) {
            arm1.setPower(.1);
            arm2.setPower(-.1);
        } else if (gamepad1.y) {
            arm1.setPower(-.1);
            arm2.setPower(.1);
        } else if (gamepad1.dpad_left) {
            arm1.setPower(.1);
            arm2.setPower(0);
        } else if (gamepad1.dpad_right) {
            arm1.setPower(-.1);
            arm2.setPower(0);
        } else if (gamepad1.left_bumper) {
            arm1.setPower(0);
            arm2.setPower(.1);
        } else if (gamepad1.right_bumper) {
            arm1.setPower(0);
            arm2.setPower(-.1);
        }else {
            arm1.setPower(0);
            arm2.setPower(0);
        }
         */
    }
}