package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@Autonomous
public class ML extends LinearOpMode
{

    private LinearOpMode mlOpMode = null;
    public static DcMotorEx rightFront;
    public static DcMotorEx rightRear;
    public static DcMotorEx leftFront;
    public static DcMotorEx leftRear;
    public static DcMotorEx intake;
    //public static DcMotor liftL;
    //public static DcMotor liftR;
    public static DcMotorEx arm;
    public static CRServo rotate;
    //public static Servo clawL;
    //public static Servo clawR;
    //public static CRServo arm1;
    //public static CRServo arm2;
    //public void iniit() throws InterruptedException { runOpMode();}

    public ML (LinearOpMode opmode) {
        mlOpMode = opmode;
    }

    //@Override
    public void iniit(){
        ML.leftFront = mlOpMode.hardwareMap.get(DcMotorEx.class,"leftFront");
        ML.leftRear = mlOpMode.hardwareMap.get(DcMotorEx.class,"leftRear");
        ML.rightFront = mlOpMode.hardwareMap.get(DcMotorEx.class,"rightFront");
        ML.rightRear = mlOpMode.hardwareMap.get(DcMotorEx.class,"rightRear");
        ML.intake = mlOpMode.hardwareMap.get(DcMotorEx.class,"intake");
        ML.arm = mlOpMode.hardwareMap.get(DcMotorEx.class,"arm");
        ML.rotate = mlOpMode.hardwareMap.get(CRServo.class,"rotate");

        ML.leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        ML.leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
        ML.rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        ML.rightRear.setDirection(DcMotorSimple.Direction.FORWARD);
        ML.intake.setDirection(DcMotorSimple.Direction.FORWARD);
        ML.arm.setDirection(DcMotorSimple.Direction.FORWARD);

        ML.leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ML.leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ML.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ML.rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        ML.leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ML.leftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ML.rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ML.rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telemetry.addData("Say", "Hello Driver");

    }

    public void runOpMode(){}
    public static void forward(int v)
    {
        move(v,0);
    }
    public static void strafe(int v)
    {
        move(v,1);
    }
    public static void turn(double n)
    {
        move((int)(400*n), 2); //positive is left
    }
    public static void move(int d, int mode) {
        leftFront.setVelocity(.4, AngleUnit.RADIANS);
        leftRear.setVelocity(.4, AngleUnit.RADIANS);
        rightFront.setVelocity(.4, AngleUnit.RADIANS);
        rightRear.setVelocity(.4, AngleUnit.RADIANS);
        /** mode is to determine if the robot is
         * driving straight, strafing, or turning
         * using 0, 1, or 2 respectively for each mode
         */
        if (mode == 0) {
            leftFront.setTargetPosition(d);
            leftRear.setTargetPosition(d);
            rightFront.setTargetPosition(d);
            rightRear.setTargetPosition(d);
        }
        if (mode == 1) {
            leftFront.setTargetPosition(-d);
            leftRear.setTargetPosition(d);
            rightFront.setTargetPosition(d);
            rightRear.setTargetPosition(-d);
        }
        if (mode == 2) {
            leftFront.setTargetPosition(-d);
            leftRear.setTargetPosition(-d);
            rightFront.setTargetPosition(d);
            rightRear.setTargetPosition(d);
        }
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while ( leftRear.getCurrentPosition() != d) {
        }
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //sleep(200);
    }
    public static void Intake(int p, int s) {

        intake.setPower(p);
        //sleep(s);
        intake.setPower(0);
        //sleep(200);
    }
}